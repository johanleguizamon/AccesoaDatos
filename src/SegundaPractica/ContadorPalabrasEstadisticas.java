package SegundaPractica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class ContadorPalabrasEstadisticas {

    public static class EstadisticasTexto {
        private int numeroLineas;
        private int numeroPalabras;
        private int numeroCaracteres;
        private String palabraMasLarga;

        public EstadisticasTexto(int numeroLineas, int numeroPalabras, int numeroCaracteres, String palabraMasLarga) {
            this.numeroLineas = numeroLineas;
            this.numeroPalabras = numeroPalabras;
            this.numeroCaracteres = numeroCaracteres;
            this.palabraMasLarga = palabraMasLarga;
        }

        public int getNumeroLineas() { return numeroLineas; }
        public int getNumeroPalabras() { return numeroPalabras; }
        public int getNumeroCaracteres() { return numeroCaracteres; }
        public String getPalabraMasLarga() { return palabraMasLarga; }

        @Override
        public String toString() {
            return "Estadísticas del archivo\n"
                    + "Líneas: " + numeroLineas + "\n"
                    + "Palabras: " + numeroPalabras + "\n"
                    + "Caracteres: " + numeroCaracteres + "\n"
                    + "Palabra más larga: " + palabraMasLarga
                    + " (" + (palabraMasLarga != null ? palabraMasLarga.length() : 0) + " caracteres)";
        }
    }

    public static EstadisticasTexto analizarArchivo(String nombreArchivo) throws IOException {
        int lineas = 0;
        int palabras = 0;
        int caracteres = 0;
        String palabraMasLarga = "";


        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(nombreArchivo), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas++;
                caracteres += linea.length();

                StringTokenizer tokenizer = new StringTokenizer(linea, " \t\n\r\f.,;:¿?¡!()[]{}\"'");
                while (tokenizer.hasMoreTokens()) {
                    String palabra = tokenizer.nextToken();
                    palabras++;
                    if (palabra.length() > palabraMasLarga.length()) {
                        palabraMasLarga = palabra;
                    }
                }
            }
        }
        return new EstadisticasTexto(lineas, palabras, caracteres, palabraMasLarga);
    }

    public static void guardarEstadisticas(EstadisticasTexto estadisticas, String archivoSalida) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivoSalida), StandardCharsets.UTF_8))) {
            writer.write(estadisticas.toString());
            writer.newLine();
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        String archivoEntrada = "archivo.txt";     // Cambia la ruta si lo necesitas
        String archivoSalida = "estadisticas.txt"; // Fichero de salida

        try {
            EstadisticasTexto estadisticas = analizarArchivo(archivoEntrada);
            System.out.println(estadisticas);
            guardarEstadisticas(estadisticas, archivoSalida);
            System.out.println("Estadísticas guardadas en: " + archivoSalida);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
