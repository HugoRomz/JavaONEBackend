package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") int totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Actors")String  actores,
        @JsonAlias("Poster") String poster,
        @JsonAlias("Plot") String sinopsis)

{
}
