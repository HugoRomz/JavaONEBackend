package com.romz.reproductor.modelos;

public class MisFavoritos {
    public void incluye(Audio audio){
        if (audio.getClasificacion() >= 8 ){
            System.out.println(audio.getTitulo()+" es de las mejores canciones del momento.");
        }else {
            System.out.println(audio.getTitulo() + "Escuchalo más tarde");
        }
    }
}
