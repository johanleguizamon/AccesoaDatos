package SegundaPractica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JSONParser {

    public static Map<String, String> leerJsonSimple(String archivoJson) throws IOException {
        Map<String, String> resultado = new LinkedHashMap<>(); // almacena el resultado
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivoJson), StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder(); // acumula texto del archivo
            String linea;
            while ((linea = reader.readLine()) != null) sb.append(linea.trim()); // leer todas las líneas
            String json = sb.toString().replaceAll("[{}\"]", ""); // limpia símbolos JSON
            String[] pares = json.split(","); // separa cada par clave:valor
            for (String par : pares) {
                String[] kv = par.split(":", 2); // divide clave y valor
                if (kv.length == 2) resultado.put(kv[0].trim(), kv[1].trim()); // añade a map
            }
        }
        return resultado; // devuelve clave-valor
    }

    public static void escribirJsonSimple(Map<String, String> datos, String archivoJson) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivoJson), StandardCharsets.UTF_8))) {
            writer.write("{\n"); // abre el JSON
            int n = 0;
            for (Map.Entry<String, String> entry : datos.entrySet()) {
                writer.write("  \"" + entry.getKey() + "\": \"" + entry.getValue() + "\""); // cada linea clave-valor
                n++;
                if (n < datos.size()) writer.write(","); // añade coma
                writer.write("\n");
            }
            writer.write("}"); // cierra el JSON
        }
    }
}
