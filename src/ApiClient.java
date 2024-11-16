import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ApiClient {

    // Realiza una solicitud a la API de tasas de cambio
    public RespuestaExchangeRateAPI getExchangeRates(String apiUrl) throws Exception {
        // Crear la conexión HTTP
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        // Verificar si la solicitud fue exitosa (código 200)
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Error en la solicitud HTTP: " + conn.getResponseCode());
        }

        // Leer la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        conn.disconnect();

        // Imprimir la respuesta completa
        System.out.println("Respuesta de la API: " + response.toString());

        // Usar Gson para convertir el JSON en un objeto Java
        Gson gson = new Gson();
        return gson.fromJson(response.toString(), RespuestaExchangeRateAPI.class);
    }
}