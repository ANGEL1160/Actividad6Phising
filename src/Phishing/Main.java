package Phishing;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> archivo = new Operaciones_ficheros().cargarfichero();
        String mensaje = new Operaciones_ficheros().cargarMensaje();

        int contadorPeligro = 0;
        for (Map.Entry<String, Integer> entry : archivo.entrySet()) {
            String key = entry.getKey();
            Integer valor = entry.getValue();
            int count = 0;
            int index = mensaje.indexOf(key);
            while (index != -1) {
                count++;
                index = mensaje.indexOf(key, index + key.length());
            }
            if (count > 0){
                contadorPeligro += valor;
                System.out.println("La palabra '" + key + "' aparece " + count + " veces en el mensaje.");
            }
        }
        System.out.printf("Puntuacion que sea Phishing es: " + contadorPeligro);
    }
}