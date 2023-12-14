package com.example.tema5ejer7;

import android.widget.BaseAdapter;

public class Animales{

    private int imagen;
    private String nombre;

    public Animales() {
    }

    public Animales(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Animales{" +
                "imagen=" + imagen +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
