package PrimeraPractica;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class EjercicioExplorador {
    public static void explorarCarpeta(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            System.out.println("✖ La ruta no existe: " + ruta);
            return;
        }
        System.out.println("Explorando: " + carpeta.getAbsolutePath());
        File[] contenido = carpeta.listFiles();
        int totalElementos = 0;
        if (contenido != null) {
            for (File elemento : contenido) {
                analizarElemento(elemento);
                totalElementos++;
            }
        }
        System.out.println("\nTotal de elementos encontrados: " + totalElementos);
    }

    public static void analizarElemento(File elemento) {
        if (elemento.isFile()) {
            System.out.println("- " + elemento.getName() + " [ARCHIVO - " + elemento.length() + " bytes]");
        } else if (elemento.isDirectory()) {
            int num = elemento.listFiles() != null ? elemento.listFiles().length : 0;
            System.out.println("- " + elemento.getName() + " [DIRECTORIO - " + num + " elementos]");
        }
    }

    public static void convertirAURI(String ruta) {
        File f = new File(ruta);
        System.out.println("\nCONVERSIÓN A URI:");
        System.out.println("Ruta original: " + f.getAbsolutePath());
        try {
            URI uri = f.toURI();
            System.out.println("URI equivalente: " + uri.toString());

            // Validar que la URI apunta al mismo elemento
            File f2 = new File(uri);
            if (f2.exists() && f2.getAbsolutePath().equals(f.getAbsolutePath())) {
                System.out.println("✔ La URI es válida y apunta al mismo elemento");
            } else {
                System.out.println("✖ Hay un problema con la conversión a URI");
            }
        } catch (Exception e) {
            System.out.println("✖ Error en la conversión: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== EXPLORADOR INTELIGENTE ===");
        System.out.print("Introduce la ruta a explorar: ");
        String ruta = sc.nextLine();

        explorarCarpeta(ruta);
        convertirAURI(ruta);

        sc.close();
    }
}
