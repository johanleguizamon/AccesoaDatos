package AccesoFicherosIO;
//Importamos FileReader y su manejo de excepciones

import java.io.FileReader;
import java.io.IOException;




public class EjemploFileReader {
    public static void main(String[] args) {
        //Variable para almacenar el caracter elido
        int caracter;
        try (FileReader fr = new FileReader("src/AccesoFicherosIO/entrada.txt/entrada.txt")){
            //read() return -1 cuando llega al final del archivo
            while ((caracter = fr.read()) != -1) {
                //convertimos int en char para mostrar el caracter
                System.out.print((char) caracter);
                 }

    } catch (IOException e) {
            System.out.print("Error al cargar el archivo" + e.getMessage());

        }


        //Resultado esperado: imprime el contenido del archivo caracter a caracter

    }

}


