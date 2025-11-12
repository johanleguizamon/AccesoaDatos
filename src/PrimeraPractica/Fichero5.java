package PrimeraPractica;

import java.io.File;
import java.io.IOException;

public class Fichero5 {
    /*public static void main(String[] args) {
        File archivo = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\nuevoArchivo.txt");

        if (!archivo.exists()) {
            try {
                boolean creado = archivo.createNewFile();
                if (creado) {
                    System.out.println("Archivo creado: " + archivo.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo ya existe: " + archivo.getAbsolutePath());
        }
    }*/

    public static void main(String[] args) throws IOException {
        //Rutas de archivo y directorio como cadena de texto
        String directorio = "C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\Padre";
        String archivo = "C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\hijo.txt";

        //Crear instancias File usando su constructor
        File dirPadre = new File(directorio);
        File archivoHijo = new File(archivo);

        //Verificar si el archivo y directorio existem
        boolean fin = false;

        do {
            if (dirPadre.exists()) {
                System.out.println("El directorio no existe");
                dirPadre.mkdir();
                System.out.println("Directorio creado correctamente");
            } else if (!archivoHijo.exists()){
                System.out.println("El archivo no existe");
                archivoHijo.createNewFile();
                 System.out.println("Archivo creado correctamente");
            }else {
                System.out.println("El directorio y archivo ya existen");
                fin = true;
            }
        }while(!fin);


    }
}

