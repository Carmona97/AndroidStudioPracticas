package com.example.tema5ejer6;

public class Datos {
    private int imagen;
    private String titulo;
    private String texto;

    public Datos(int imagen, String titulo, String texto) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "imagen=" + imagen +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


}
