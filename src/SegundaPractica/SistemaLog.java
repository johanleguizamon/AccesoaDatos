package SegundaPractica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Niveles de log disponibles.
 */
enum NivelLog {
    INFO, WARNING, ERROR
}

/**
 * Sistema de Log con rotación por tamaño.
 */
public class SistemaLog {
    private final String archivoLog; // ruta del log principal
    private final long tamanoMaximo; // tamaño máximo en bytes
    private int numeroRotacion = 1; // número para los logs rotados

    /**
     * Crea el sistema de log.
     * @param archivoLog Ruta del archivo log.
     * @param tamanoMaximo Tamaño máximo del log en bytes.
     */
    public SistemaLog(String archivoLog, long tamanoMaximo) {
        this.archivoLog = archivoLog;
        this.tamanoMaximo = tamanoMaximo;
    }

    /**
     * Escribe un mensaje en el log con timestamp y nivel.
     * @param mensaje Mensaje a registrar.
     * @param nivel Nivel del log.
     * @throws IOException si hay error al escribir.
     */
    public void escribirLog(String mensaje, NivelLog nivel) throws IOException {
        // rotar si es necesario antes de escribir
        rotarSiNecesario();

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(archivoLog, true), StandardCharsets.UTF_8))) {
            String timestamp = obtenerTimestamp();
            writer.write("[" + timestamp + "] [" + nivel + "] " + mensaje);
            writer.newLine();
            writer.flush(); // escribir de inmediato
        }
        System.out.println("Log escrito: " + mensaje); // feedback en consola
    }

    // Obtiene el timestamp en formato ISO 8601.
    private String obtenerTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * Rotación del log si supera tamaño máximo.
     * @return true si se rotó, false si no.
     * @throws IOException si hay error en rotación.
     */
    private boolean rotarSiNecesario() throws IOException {
        long tamanoActual = obtenerTamanoLog();
        if (tamanoActual >= tamanoMaximo) {
            String archivoRotado = archivoLog + "." + numeroRotacion;
            File logFile = new File(archivoLog);
            File logRotated = new File(archivoRotado);
            if (logRotated.exists()) logRotated.delete();
            boolean exito = logFile.renameTo(logRotated);
            if (exito) {
                numeroRotacion++;
                System.out.println("ROTACIÓN: " + archivoLog + " renombrado a " + archivoRotado);
                // crea nuevo log vacío
                try (BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivoLog), StandardCharsets.UTF_8))) {
                    writer.write(""); // crea archivo limpio
                    writer.flush();
                }
                return true;
            } else {
                throw new IOException("No se pudo rotar el log.");
            }
        }
        return false;
    }

    // Obtiene el tamaño actual del log en bytes.
    private long obtenerTamanoLog() {
        File log = new File(archivoLog);
        return log.exists() ? log.length() : 0;
    }
}

