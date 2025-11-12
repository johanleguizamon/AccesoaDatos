package SegundaPractica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class BackupIncremental {

    public static int backupIncremental(String carpetaOrigen, String carpetaDestino, String archivoControl) throws IOException {
        long ultimoBackup = leerUltimoBackup(archivoControl); // último backup
        File origen = new File(carpetaOrigen);
        File destino = new File(carpetaDestino);

        if (!destino.exists()) destino.mkdirs(); // crear destino

        int archivosCopiados = 0;
        for (File archivo : origen.listFiles()) {
            if (archivo.isFile() && archivo.lastModified() > ultimoBackup) {
                File archivoDestino = new File(destino, archivo.getName());
                copiarArchivo(archivo, archivoDestino); // copiar archivo
                archivosCopiados++;
                System.out.println("Copiando: " + archivo.getName()); // mostrar nombre
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivoControl), StandardCharsets.UTF_8))) {
            writer.write(Long.toString(System.currentTimeMillis())); // actualizar control
        }
        return archivosCopiados;
    }

    private static long leerUltimoBackup(String archivoControl) throws IOException {
        File f = new File(archivoControl);
        if (!f.exists()) return 0; // si no existe, devolver 0
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = reader.readLine();
            return line != null ? Long.parseLong(line.trim()) : 0; // leer timestamp
        }
    }

    private static void copiarArchivo(File origen, File destino) throws IOException {
        Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING); // copiar archivo
    }
}

