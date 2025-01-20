package com.aluracursos.screenmatch_desafio_frases.controller;

import com.aluracursos.screenmatch_desafio_frases.dto.FraseDTO;
import com.aluracursos.screenmatch_desafio_frases.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class FraseController {

    @Autowired
    FraseService service;

    @GetMapping("/frases")
    public FraseDTO obtenerFraseAleatoria(){
    return service.obtenerFraseAleatoria();
    }

}
