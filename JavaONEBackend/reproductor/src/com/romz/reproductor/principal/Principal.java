package com.romz.reproductor.principal;

import com.romz.reproductor.modelos.Cancion;
import com.romz.reproductor.modelos.MisFavoritos;
import com.romz.reproductor.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Cancion cancion1 = new Cancion();

        cancion1.setTitulo("Rosanna");
        cancion1.setArtista("Toto");

        Podcast podcast1 = new Podcast();
        podcast1.setTitulo("Haciendo Rol");
        podcast1.setInvitado("Peele");
        podcast1.setEpisodio(1);

        for (int i = 0; i < 300; i++) {
            cancion1.meGusta();
        }
        for (int i = 0; i < 5700; i++) {
            cancion1.reproduce();
        }

        for (int i = 0; i < 3000; i++) {
            podcast1.reproduce();
        }

        System.out.println("Total de reproducciones de "+cancion1.getTitulo()+": "+cancion1.getTotalDeReproducciones());
        System.out.println("Total de me gusta de "+cancion1.getTitulo()+": "+cancion1.getTotalDeMeGusta());

        System.out.println("Total de reproducciones de "+podcast1.getTitulo()+": "+cancion1.getTotalDeReproducciones());

        MisFavoritos favoritos = new MisFavoritos();

        favoritos.incluye(cancion1);
        favoritos.incluye(podcast1);
    }
}
