package SegundaPractica;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MergeArchivosFiltrado {

    // Combina archivos de entrada, filtra y guarda resultado
    public static int combinarArchivos(String[] archivosEntrada, String archivoSalida, String filtro) throws IOException {
        int totalLineas = 0;
        // BufferedWriter para salida en UTF-8
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivoSalida), StandardCharsets.UTF_8))) {
            // Procesar cada archivo de entrada
            for (String nombreArchivo : archivosEntrada) {
                int lineasCoinciden = 0;
                // BufferedReader para entrada en UTF-8
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(nombreArchivo), StandardCharsets.UTF_8))) {
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        if (cumpleFiltro(linea, filtro)) { // Filtrar línea
                            writer.write(linea);
                            writer.newLine();
                            totalLineas++;
                            lineasCoinciden++;
                        }
                    }
                }
                System.out.println("Procesando " + nombreArchivo + ": " + lineasCoinciden + " líneas coinciden");
            }
        }
        System.out.println("Total " + totalLineas + " líneas escritas en " + archivoSalida);
        return totalLineas;
    }

    // Comprueba si la línea cumple el filtro (o no hay filtro)
    private static boolean cumpleFiltro(String linea, String filtro) {
        // Si filtro es null, acepta todas las líneas
        return (filtro == null) || linea.contains(filtro);
    }

    // Main de prueba
    public static void main(String[] args) {
        // Cambia los nombres de aquí o pide por teclado según prefieras
        String[] entradas = {"archivo1.txt", "archivo2.txt"};
        String salida = "combinado.txt";
        String filtro = "Java"; // Usa null para no filtrar

        try {
            combinarArchivos(entradas, salida, filtro); // Ejecutar función principal
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage()); // Error entrada/salida
        }
    }
}
