package AccesoFicherosIO;

import java.io.FileWriter;
import java.io.IOException;

public class EjemploFileWriter {
    public static void main(String[] args) {
        //Contenido que queremos escribir
        String contenido = "Primera linea\nSegunda linea\nTercera linea";

        //TryCatch cierra automaticamente el fileWriter
        //Por defecto sobreescribe el archivo si existe
        try (FileWriter fw = new FileWriter("src/AccesoFicherosIO/salida.txt")) {
            //Escribe la cadena completa
            fw.write(contenido);
            //flush() se llama automaticamente al final
        } catch (IOException e) {
            System.out.print("Error al cargar el archivo" + e.getMessage());

        }
    }
}


//Resultado esperado: imprime el contenido del archivo caracter a caracter