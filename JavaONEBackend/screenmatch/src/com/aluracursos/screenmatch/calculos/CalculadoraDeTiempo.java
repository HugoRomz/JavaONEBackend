package com.aluracursos.screenmatch.calculos;
import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo){
        System.out.println("Agregando duración en minutos de" + titulo);
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

}
