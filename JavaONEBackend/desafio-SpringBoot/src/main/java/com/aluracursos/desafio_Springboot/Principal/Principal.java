package com.aluracursos.desafio_Springboot.Principal;

import com.aluracursos.desafio_Springboot.services.ConsumoAPI;
import com.aluracursos.desafio_Springboot.services.ConvierteDatos;
import model.Datos;
import model.DatosLibros;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String API_URL = "https://gutendex.com/books/";

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarMenu(){
        var json = consumoAPI.obtenerDatos(API_URL);
//        System.out.println(json);

        var datos = conversor.obtenerDatos(json, Datos.class);
//        System.out.println(datos);

        System.out.println("Los 10 libros mas descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);


        System.out.println("Libro que desea buscar:");
        var titulo = teclado.nextLine();
        json = consumoAPI.obtenerDatos(API_URL+"?search="+titulo.replace(" ", "+"));

        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroOptional = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(titulo.toUpperCase()))
                .findFirst();

        if (libroOptional.isPresent()){
            System.out.println("Libro Encontrado:");
            System.out.println(libroOptional.get());
        }else {
            System.out.println("El libro no se encontro");
        }

        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d-> d.numeroDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDescargas));

        System.out.println("Media de descargas: " + est.getAverage());
        System.out.println("Cantidad Maxima de descargas: " + est.getMax());
        System.out.println("Cantidad Minima de descargas: " + est.getMin());
    }
}
