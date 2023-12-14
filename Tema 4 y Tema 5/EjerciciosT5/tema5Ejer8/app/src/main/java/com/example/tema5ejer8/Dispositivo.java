package com.example.tema5ejer8;

import android.widget.CheckBox;

public class Dispositivo {

    private boolean checkbox;
    private int imagen;

    private String texto;

    public Dispositivo(boolean checkbox, int imagen, String texto) {
        this.checkbox = checkbox;
        this.imagen = imagen;
        this.texto = texto;
    }


    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    @Override
    public String toString() {
        return "Dispositivo{" +
                "checkbox=" + checkbox +
                ", imagen=" + imagen +
                ", texto='" + texto + '\'' +
                '}';
    }
}
