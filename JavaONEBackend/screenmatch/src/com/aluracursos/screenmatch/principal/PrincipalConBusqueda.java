package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloPokeApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();


        Scanner teclado = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        while (true){
            System.out.println("Escribe el nombre del pokemon");
            var busqueda = teclado.nextLine();

            if (busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String url = "https://pokeapi.co/api/v2/pokemon/" + busqueda.replace(" ", "-");
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //System.out.println(json);



                TituloPokeApi miTituloPoke = gson.fromJson(json, TituloPokeApi.class);
                System.out.println(miTituloPoke);

                Titulo miTitulo = new Titulo(miTituloPoke);
                System.out.println(miTitulo);

                titulos.add(miTitulo);

            } catch (NullPointerException  | IllegalArgumentException e) {
                System.out.println("Error en la URI:");
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("Error:");
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter writer = new FileWriter("pokemones.json");
        writer.write(gson.toJson(titulos));
        writer.close();
        System.out.println("Fin del programa");
    }
}
