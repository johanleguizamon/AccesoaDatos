package AccesoFicherosIO;

import java.io.IOException;
import java.io.RandomAccessFile;

public class EjemploRandomAccessFile {
    public static void main(String[] args)  {
        //TryCatch cierra automaticamente el RandomAccessFile
        try(RandomAccessFile raf = new RandomAccessFile("src/AccesoFicherosIO/datos.bin", "rw")) {
            //Escribimos en diferentes posiciones
            raf.writeBytes("INICIO");

            //Nos movemos a la posicion 20
            raf.seek(20);
            raf.writeBytes("MEDIO");

            //Nos movemos a la posicion 40
            raf.seek(40);
            raf.writeBytes("FINAL");

            //Volver al inicio para leer
            raf.seek(0);
            System.out.println("Posicion 0: " + raf.readLine());


            raf.seek(20);
            System.out.println("Posicion 20" + raf.readLine());

            raf.seek(40);
            System.out.println("Posicion 40" + raf.readLine());

            //Mostrar la longitud total del archivo
            System.out.println("Tamaño del archivo: " + raf.length() + "bytes");

        }catch (IOException e) {
            System.err.println("Error al acceder al archivo: " + e.getMessage());
        }

        //Resultado esperado: escritura y lectura en posiciones especificas del archivo
    }
}
