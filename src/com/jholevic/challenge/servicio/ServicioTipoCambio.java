package com.jholevic.challenge.servicio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jholevic.challenge.modelos.RespuestaTipoCambio;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioTipoCambio {
    private static final String API_KEY = "938ca1e582372ffe21f80d51";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public RespuestaTipoCambio obtenerTasa(String monedaBase) throws IOException, InterruptedException {
        // Validar moneda base
        if (monedaBase == null || monedaBase.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda base no puede estar vacía");
        }

        String url = BASE_URL + API_KEY + "/latest/" + monedaBase.toUpperCase();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar código de estado HTTP
        if (response.statusCode() != 200) {
            throw new IOException("Error en la API. Código: " + response.statusCode());
        }

        String json = response.body();
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

        // Verificar si la respuesta fue exitosa
        if (!jsonObject.get("result").getAsString().equals("success")) {
            String errorType = jsonObject.has("error-type") ? jsonObject.get("error-type").getAsString() : "desconocido";
            throw new IOException("Error en la API: " + errorType);
        }

        return new Gson().fromJson(json, RespuestaTipoCambio.class);
    }
}