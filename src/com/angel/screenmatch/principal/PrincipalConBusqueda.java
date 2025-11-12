package com.angel.screenmatch.principal;

import com.angel.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.angel.screenmatch.modelos.Titulo;
import com.angel.screenmatch.modelos.TituloOMDb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("Ingrese el nombre de la película: ");
            var busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }
            
            String direcion = "https://www.omdbapi.com/?t=" +
                    busqueda.replace(" ","+") +
                    "&apikey=4c23fb78";

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direcion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOMDb miTituloOmdb = gson.fromJson(json, TituloOMDb.class);

                System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido:" + miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException e) {

                System.out.println("Ocurrió un erro: ");
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {

                System.out.println("Error en la URI, identifique la dirección.");
                System.out.println(e.getMessage());

            } catch (ErrorEnConversionDeDuracionException e) {

                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("Finalizo la ejecución del programa!!");
    }
}
