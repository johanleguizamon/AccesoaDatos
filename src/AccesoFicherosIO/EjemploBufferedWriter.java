package AccesoFicherosIO;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploBufferedWriter {
    public static void main(String[] args)  {
        //Array con lineas a escribir
        String[] lineas = {
                "Encabezado del documento",
                "Esta es la primera linea del documento",
                "Esta es la segunda linea",
                "Final del documento"
        };

        //BufferedWriter envuelve al objeto FileWriter para añadir Buffering,
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/AccesoFicherosIO/entrada_buffered.txt"))) {

            for (String linea : lineas) {
                //la escritura en el documento
                bw.write(linea);
                //El salto de linea
                bw.newLine();
            }
            //flush() se llama automatomaticamente al final
        }catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
        //Resultado esperado:
    }
}
