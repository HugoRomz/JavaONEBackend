package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Oppenheimer",2023);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Interestellar",2015);
        otraPelicula.evalua(9.5);
        var peliculaDeRafa = new Pelicula("1917",2019);
        peliculaDeRafa.evalua(10);

        Serie casaDragon = new Serie("House of Dragon",2022);

        List<Titulo> lista = new LinkedList<>();
        lista.add(peliculaDeRafa);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(casaDragon);

        for (Titulo item: lista){
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3)
            {
            System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listadeArtistas = new ArrayList<>();
        listadeArtistas.add("Brian Culberston");
        listadeArtistas.add("Junior Klan");
        listadeArtistas.add("Ana de Armas");

        System.out.println("Lista de artistas no ordenadas" + listadeArtistas);
        Collections.sort(listadeArtistas);
        System.out.println("Lista de artistas ordenadas" + listadeArtistas);

        Collections.sort(lista);
        System.out.println("Lista ordenada"+lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha"+lista);
    }
}
