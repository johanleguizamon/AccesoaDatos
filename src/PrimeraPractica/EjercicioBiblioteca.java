package PrimeraPractica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioBiblioteca {

    // Función que organiza la biblioteca: crea una categoría y su catalogo
    public static void organizarBiblioteca(Scanner sc) {
        System.out.print("Introduce el nombre de la categoría: ");
        String categoria = sc.nextLine();

        // Carpeta de la categoría
        File carpetaCategoria = new File("C:\\biblioteca\\" + categoria);
        if (!carpetaCategoria.exists()) {
            if (carpetaCategoria.mkdirs()) {
                System.out.println("✔ Categoría '" + categoria + "' creada exitosamente");
            } else {
                System.out.println("✖ Error al crear la categoría");
                return;
            }
        } else {
            System.out.println("✔ La categoría '" + categoria + "' ya existe");
        }

        // Archivo catalogo.txt dentro de la categoría
        File catalogo = new File(carpetaCategoria, "catalogo.txt");
        try {
            if (!catalogo.exists()) {
                if (catalogo.createNewFile()) {
                    System.out.println("✔ Catálogo creado en: " + catalogo.getAbsolutePath());
                } else {
                    System.out.println("✖ Error al crear el catálogo");
                }
            } else {
                System.out.println("✔ EL catálogo ya existe en: " + catalogo.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("✖ Error al crear el catálogo: " + e.getMessage());
        }
    }

    // Función que verifica si existe el libro, si no pregunta si lo crea
    public static void verificarLibro(Scanner sc) {
        System.out.print("Introduce la categoría del libro: ");
        String categoria = sc.nextLine();

        System.out.print("Introduce el nombre del libro: ");
        String nombreLibro = sc.nextLine();

        File libro = new File("C:\\biblioteca\\" + categoria + "\\" + nombreLibro);
        if (libro.exists()) {
            System.out.println("✔ El libro existe en: " + libro.getAbsolutePath());
            System.out.println("Tamaño: " + libro.length() + " bytes");
        } else {
            System.out.println("✖ El libro no existe en: " + libro.getAbsolutePath());
            System.out.print("¿Quieres crear el libro? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                try {
                    // Aseguramos que la carpeta existe
                    libro.getParentFile().mkdirs();
                    if (libro.createNewFile()) {
                        System.out.println("✔ Libro creado exitosamente en: " + libro.getAbsolutePath());
                    } else {
                        System.out.println("✖ No se pudo crear el libro");
                    }
                } catch (IOException e) {
                    System.out.println("✖ Error al crear el libro: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menú sencillo para probar ambas funciones
        System.out.println("=== ORGANIZADOR DE BIBLIOTECA ===");
        organizarBiblioteca(sc);
        verificarLibro(sc);

        sc.close();
    }
}
