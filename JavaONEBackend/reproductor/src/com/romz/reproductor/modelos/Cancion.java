package com.romz.reproductor.modelos;

public class Cancion extends Audio{
    private String autor;
    private String album;
    private String artista;

    @Override
    public int getClasificacion() {
        if (getTotalDeReproducciones() > 5000){
            return 9;
        }else{
            return 5;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
