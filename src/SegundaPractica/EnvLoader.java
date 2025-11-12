package SegundaPractica;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class EnvLoader {
    private static Map<String, String> envVars = new HashMap<>();

    public static Map<String, String> cargarEnv(String archivoEnv) throws IOException {
        envVars.clear();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivoEnv), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("#") || linea.isEmpty()) continue; // saltar comentarios
                String[] partes = linea.split("=", 2);
                if (partes.length == 2) {
                    envVars.put(partes[0].trim(), partes[1].trim()); // guardar variable
                }
            }
        }
        return new HashMap<>(envVars);
    }

    public static String getEnv(String clave, String valorPorDefecto) {
        return envVars.getOrDefault(clave, valorPorDefecto); // devolver variable
    }
}

