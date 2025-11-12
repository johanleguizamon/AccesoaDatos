package AccesoFicherosIO;

//Importamos las librerias de Buffered(FileReadeer y su manejo de excepciones

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EjemploBufferedReader {
    public static void main(String[] args) {
        //variable para almacenar la linea leida
        String linea;
        //contador de lineas
        int numLinea = 1;

        try(BufferedReader br = new BufferedReader(new FileReader("src/AccesoFicherosIO/entrada_buffered.txt"))) {
            //readLine() retorna null cuando no hay mas lineas
            while ((linea = br.readLine()) != null) {
                System.out.println(numLinea + ": " + linea);
                numLinea++;
            }

        }catch (IOException e) {
            System.err.println("Error al cargar el archivo" + e.getMessage());
        }

    }
}
