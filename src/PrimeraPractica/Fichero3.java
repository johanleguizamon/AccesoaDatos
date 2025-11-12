package PrimeraPractica;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class Fichero3 {
    public static void main(String[] args) {
       /* try {
            // Ruta usando URI
            File ruta = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\hijo.txt");

            // Creamos el objeto File y verificamos si existe
            if (ruta.exists()) {
                System.out.println("Existe: " + ruta.getAbsolutePath());

                // Verificamos si es directorio o archivo
                if (ruta.isDirectory()) {
                    System.out.println("Es un directorio.");
                } else if (ruta.isFile()) {
                    System.out.println("Es un archivo.");
                }
            } else {
                System.out.println("No existe: " + ruta.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }*/

        //Usamos try vatch porque el objeto uri tiende a dar errores al trabajar con este
        try {
            String uriString = "C:/Users/AlumnoAfternoon/Documents/Pruebas Java/hijo.txt";
            URI uri = new URI(uriString);

            File ruta= new File(uri);

            //Verificar si el archivo existe
            if (ruta.exists()) {
                //Verificar si la ruta especificada es un directorio o un archivo
                if (ruta.isDirectory()) {
                    //Si en la ruta el ultimo elemento es un directorio muestra un mensaje diciendo que es un directorio
                    System.out.println("La ruta presenta un directorio en: " +uri.toString());
                }
                //Verificar si la ruta especificada es un directorio o un archivo
              else if (ruta.isFile()) {
                    //Si en la ruta el ultimo elemento es un archivo muestra un mensaje diciendo que es un archivo
                    System.out.println("La ruta presenta un archivo en: " + uri.toString());
                }
            }else {
                System.out.println("La uri no existe: " + uri.toString());
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
