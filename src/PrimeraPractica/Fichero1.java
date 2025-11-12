package PrimeraPractica;

import java.io.File;

public class Fichero1 {

    public static void main(String[] args) {
        //Directorio padre que acabamos de crear en la ruta de Documentos
        File dirPadre = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java");

        //Nombre a ruta relativa al fichero que acabo de crear
        String nomHijo = "hijo.txt";

        //Creo una instancia hacia File usando el constructor y la variable de arriba
        File archivo = new File(dirPadre, nomHijo);

        //Verificar si el archivo existe
        if (archivo.exists()) {
            //Si el archivo existe se muestra un mensaje y la ruta completa especificada
            System.out.println("El archivo existe en la ruta: " + archivo.getAbsolutePath());

            //Si el archivo no existe se muestra un mensaje y la ruta completa especificada
        }else {
            System.out.println("El archivo no existe en la ruta: " + archivo.getAbsolutePath());
        }


    }
}
