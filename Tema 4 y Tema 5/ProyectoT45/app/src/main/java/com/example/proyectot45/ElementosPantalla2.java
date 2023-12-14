package com.example.proyectot45;

import android.widget.Button;

public class ElementosPantalla2 {
    private int imagen;
    private String textoJuego;
    private Button carrito;
    private String url;




    public ElementosPantalla2(int imagen, String textoJuego, String url) {
        this.imagen = imagen;
        this.textoJuego = textoJuego;
        this.url = url;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTextoJuego() {
        return textoJuego;
    }

    public void setTextoJuego(String textoJuego) {
        this.textoJuego = textoJuego;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
