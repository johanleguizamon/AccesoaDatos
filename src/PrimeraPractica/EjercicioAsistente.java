package PrimeraPractica;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class EjercicioAsistente {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            switch (opcion) {
                case 1 -> verificarArchivo();
                case 2 -> explorarDirectorio();
                case 3 -> crearCarpeta();
                case 4 -> crearArchivo();
                case 5 -> trabajarConURIs();
                case 6 -> System.out.println("¡Hasta pronto! Gracias por usar el asistente.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===============================");
        System.out.println("     MI ASISTENTE DE ARCHIVOS ");
        System.out.println("===============================");
        System.out.println("1. Verificar si un archivo existe");
        System.out.println("2. Explorar una carpeta");
        System.out.println("3. Crear una nueva carpeta");
        System.out.println("4. Crear un nuevo archivo");
        System.out.println("5. Trabajar con URIs");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }

    private static int obtenerOpcion() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private static void verificarArchivo() {
        System.out.println("\n--- VERIFICAR ARCHIVO ---");
        System.out.print("Introduce el directorio padre: ");
        String dirPadre = scanner.nextLine().trim();
        System.out.print("Introduce el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine().trim();

        File archivo = new File(dirPadre, nombreArchivo);
        if (archivo.exists()) {
            System.out.println("✔ El archivo existe en: " + archivo.getAbsolutePath());
            if (archivo.isFile()) {
                System.out.println("Es un archivo de " + archivo.length() + " bytes");
            } else if (archivo.isDirectory()) {
                System.out.println("Es un directorio");
            }
        } else {
            System.out.println("✖ El archivo NO existe en: " + archivo.getAbsolutePath());
        }
        pausar();
    }

    private static void explorarDirectorio() {
        System.out.println("\n--- EXPLORAR DIRECTORIO ---");
        System.out.print("Introduce la ruta del directorio: ");
        String ruta = scanner.nextLine().trim();

        File dir = new File(ruta);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("✖ La ruta no corresponde a un directorio");
        } else {
            File[] contenido = dir.listFiles();
            int total = 0;
            System.out.println("Contenido del directorio:");
            if (contenido != null) {
                for (File elemento : contenido) {
                    total++;
                    System.out.println(total + ". " + elemento.getName());
                }
            }
            System.out.println("Total: " + total + " elementos");
        }
        pausar();
    }

    private static void crearCarpeta() {
        System.out.println("\n--- CREAR CARPETA ---");
        System.out.print("Introduce la ruta de la nueva carpeta: ");
        String ruta = scanner.nextLine().trim();

        File carpeta = new File(ruta);
        if (carpeta.exists()) {
            System.out.println("⚠ La carpeta ya existe en: " + carpeta.getAbsolutePath());
        } else {
            if (carpeta.mkdirs()) {
                System.out.println("✔ Carpeta creada exitosamente en: " + carpeta.getAbsolutePath());
            } else {
                System.out.println("✖ Error al crear la carpeta.");
            }
        }
        pausar();
    }

    private static void crearArchivo() {
        System.out.println("\n--- CREAR ARCHIVO ---");
        System.out.print("Introduce la ruta completa del nuevo archivo: ");
        String ruta = scanner.nextLine().trim();

        File archivo = new File(ruta);
        try {
            // Crear los directorios padres si no existen
            archivo.getParentFile().mkdirs();
            if (archivo.exists()) {
                System.out.println("⚠ El archivo ya existe: " + archivo.getAbsolutePath());
            } else if (archivo.createNewFile()) {
                System.out.println("✔ Archivo creado exitosamente en: " + archivo.getAbsolutePath());
            } else {
                System.out.println("✖ Error al crear el archivo.");
            }
        } catch (IOException e) {
            System.out.println("✖ Error (IOException): " + e.getMessage());
        }
        pausar();
    }

    private static void trabajarConURIs() {
        System.out.println("\n--- TRABAJAR CON URIs ---");
        System.out.println("Elige una opción:");
        System.out.println("1. Verificar una URI existente");
        System.out.println("2. Convertir ruta a URI");

        int opcion = obtenerOpcion();
        switch (opcion) {
            case 1 -> verificarURI();
            case 2 -> convertirRutaAURI();
            default -> System.out.println("Opción no válida.");
        }
        pausar();
    }

    private static void verificarURI() {
        System.out.print("Introduce la URI (ejemplo file:///C:/ruta/archivo.txt): ");
        String entrada = scanner.nextLine();
        try {
            URI uri = new URI(entrada.trim());
            File archivo = new File(uri);
            if (archivo.exists()) {
                System.out.println("✔ La URI representa un " + (archivo.isDirectory() ? "directorio" : "archivo") +
                        " en: " + archivo.getAbsolutePath());
            } else {
                System.out.println("✖ La URI no corresponde a ningún elemento existente");
            }
        } catch (Exception e) {
            System.out.println("✖ Error al verificar la URI: " + e.getMessage());
        }
    }

    private static void convertirRutaAURI() {
        System.out.print("Introduce la ruta a convertir: ");
        String ruta = scanner.nextLine().trim();
        File archivo = new File(ruta);
        System.out.println("Ruta original: " + archivo.getAbsolutePath());
        URI uri = archivo.toURI();
        System.out.println("URI generada: " + uri.toString());
        if (archivo.exists()) {
            System.out.println("✔ La ruta existe y la URI es válida");
        } else {
            System.out.println("✖ La ruta no existe en el sistema");
        }
    }

    private static void pausar() {
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
}
