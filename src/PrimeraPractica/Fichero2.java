package PrimeraPractica;

import java.io.File;

public class Fichero2 {
    public static void main(String[] args) {
        //Directorio padre que acabamos de crear en la ruta de Documentos
        File ruta = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\hijo.txt");

        //Verificar si el archivo existe
        if (ruta.exists()) {
            //Verificar si la ruta especificada es un directorio o un archivo
            if (ruta.isDirectory()) {
                //Si en la ruta el ultimo elemento es un directorio muestra un mensaje diciendo que es un directorio
                System.out.println("La ruta presenta un directorio en: " + ruta.getAbsolutePath());
            }
                //Verificar si la ruta especificada es un directorio o un archivo
            if (ruta.isFile()) {
                //Si en la ruta el ultimo elemento es un archivo muestra un mensaje diciendo que es un archivo
                System.out.println("La ruta presenta un archivo en: " + ruta.getAbsolutePath());
            }
        }
    }
}
