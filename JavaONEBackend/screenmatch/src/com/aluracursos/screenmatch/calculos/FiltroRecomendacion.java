package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtra(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Mejores del momento");
        }else if (clasificacion.getClasificacion() >=2 ){
            System.out.println("Popular en el momento");
        }else {
            System.out.println("Mirar más tarde.");
        }
    }
}

