package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> obtenerTodasLasSeries(){
        return convierteDatos(repository.findAll());
    }

    public List<SerieDTO> obtenerTop5Series() {
        return convierteDatos(repository.findTop5ByOrderByEvaluacionDesc());
    }
    public List<SerieDTO> obtenerLanzamientosMasRecientes() {
        return convierteDatos(repository.lanzamientosRecientes());
    }

    public SerieDTO obtenerPorId(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()){
            Serie s =  serie.get();
            return new SerieDTO(s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getEvaluacion(),s.getGenero(),s.getActores(),
                    s.getPoster(), s.getSinopsis());
        }else {
            return null;
        }
    }
    public List<EpisodioDTO> obtenerTodasLasTemporadas(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()){
            Serie s =  serie.get();
            return s.getEpisodios().stream()
                    .map(episodio -> new EpisodioDTO(episodio.getTemporada(), episodio.getTitulo(), episodio.getNumeroEpisodio(), episodio.getFechaLanzamiento()))
                    .collect(Collectors.toList());
        }else {
            return null;
        }
    }

    public List<EpisodioDTO> obtenerTemporadaPorNumero(Long id, Long numTemporada) {
        return repository.obtenerTemporadasPorNumero(id, numTemporada).stream()
                .map(episodio -> new EpisodioDTO(episodio.getTemporada(), episodio.getTitulo(),episodio.getNumeroEpisodio(), episodio.getFechaLanzamiento()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obtenerSeriesPorCategoria(String nombreGenero) {
        Categoria categoria = Categoria.fromEspaniol(nombreGenero);
        return convierteDatos(repository.findByGenero(categoria));
    }

    public List<EpisodioDTO> obtenerTop5Episodios(Long id) {
        var serie = repository.findById(id).get();
        return repository.top5Episodios(serie).stream()
                .map(e -> new EpisodioDTO(e.getTemporada(),e.getTitulo(),e.getNumeroEpisodio(),e.getFechaLanzamiento()))
                .collect(Collectors.toList());
    }


    public List<SerieDTO> convierteDatos(List<Serie> serie){
        return serie.stream()
                .map(s -> new SerieDTO(s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getEvaluacion(),s.getGenero(),s.getActores(),
                        s.getPoster(), s.getSinopsis()))
                .collect(Collectors.toList());
    }

}
