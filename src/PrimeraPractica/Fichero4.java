package PrimeraPractica;

import java.io.File;

public class Fichero4 {
    public static void main(String[] args) {
       /* File directorio = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java");

        if (directorio.exists() && directorio.isDirectory()) {
            // Mostrar nombres de los elementos dentro de la carpeta
            String[] listaArchivos = directorio.list();
            if (listaArchivos != null) {
                System.out.println("Contenido de la carpeta:");
                for (String nombre : listaArchivos) {
                    System.out.println(nombre);
                }
                System.out.println("Total elementos: " + listaArchivos.length);
            }
        } else {
            System.out.println("No es un directorio o no existe.");
        }*/

        //Ruta del directorio como cadena de texto
        String dirPadre = "C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\hijo.txt";

        //Creacion de la instancia usando el constructor File
        File directorio = new File(dirPadre);

        //  Verificar si el archivo existe y si es un directorio
        if (directorio.exists() && directorio.isDirectory()) {
            //Creacion de un array del contenido dentro de la carpeta
            String[] contenido = directorio.list();

            //Bucle en el cual pasamos mostrando el contenido de la carpeta de uno en uno
            for (int i = 0; 1 < contenido.length; i++) {
                System.out.println(contenido[i]);
            }
        }else {
            System.out.println("La siguiente ruta no es un directorio o no existe");
        }
    }

}

