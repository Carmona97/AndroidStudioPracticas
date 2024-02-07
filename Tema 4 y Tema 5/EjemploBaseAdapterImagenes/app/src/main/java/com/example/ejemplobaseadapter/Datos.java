package com.example.ejemplobaseadapter;

import android.widget.ImageView;

public class Datos {

    private String texto;
    private int icono;

    public Datos(int icono,String texto){
        this.texto = texto;
        this.icono = icono;


    }

    public String getTexto(){
        return texto;
    }

    public int getImagen(){
        return icono;
    }
}
