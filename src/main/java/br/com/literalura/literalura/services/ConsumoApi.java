package br.com.literalura.literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsumoApi {
    public String consomeApi(String arg){
        var argumentoNormalizado = URLEncoder.encode(arg, StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newHttpClient();

        var uri = "https://gutendex.com/books/?search=" + argumentoNormalizado;

        System.out.println(uri);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        System.out.println(request);
        HttpResponse<String> response = null;

        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);

            if (response.statusCode() != 200) {
                System.out.println("Erro: Status " + response.statusCode());
                return "";
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consumir API", e);
        }
        return response.body();
    }
}
