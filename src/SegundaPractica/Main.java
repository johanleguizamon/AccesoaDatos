package SegundaPractica;

public class Main {
    public static void main(String[] args) {
        try {
            SistemaLog log = new SistemaLog("app.log", 1026); // 1KB máximo para el log
            log.escribirLog("Aplicación iniciada", NivelLog.INFO);
            log.escribirLog("Usuario conectado", NivelLog.INFO);
            log.escribirLog("Error de conexión", NivelLog.ERROR);
            // Puedes seguir escribiendo más logs para probar la rotación
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
