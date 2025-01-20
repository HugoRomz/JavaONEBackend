package com.aluracursos.screenmatch_desafio_frases.service;

import com.aluracursos.screenmatch_desafio_frases.dto.FraseDTO;
import com.aluracursos.screenmatch_desafio_frases.model.Frase;
import com.aluracursos.screenmatch_desafio_frases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repositorio;

    public FraseDTO obtenerFraseAleatoria() {
        Frase frase = repositorio.obtenerFraseAleatoria();

        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonaje(), frase.getPoster());

    }
}
