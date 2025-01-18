package com.aluracursos.desafio_Springboot.services;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
