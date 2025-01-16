import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        MostrarPelicula consulta = new MostrarPelicula();
        Scanner teclado = new Scanner(System.in);
        System.out.println("ESCRIBE EL NUMERO DE LA PELICULA:");

        try {
            int busqueda = teclado.nextInt();
            Pelicula pelicula = consulta.buscarPelicula(busqueda);

            FileWriter writer = new FileWriter(pelicula.title()+".json");
            writer.write(gson.toJson(pelicula));
            writer.close();

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}