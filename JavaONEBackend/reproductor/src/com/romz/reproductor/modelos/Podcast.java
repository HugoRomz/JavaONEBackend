package com.romz.reproductor.modelos;

public class Podcast extends Audio{
    private int episodio;
    private String invitado;

    @Override
    public int getClasificacion() {
        if (getTotalDeReproducciones() > 300){
            return 9;
        }else {
            return 6;
        }
    }

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    public String getInvitado() {
        return invitado;
    }

    public void setInvitado(String invitado) {
        this.invitado = invitado;
    }
}
