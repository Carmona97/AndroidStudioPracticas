package com.example.carmonajuanmanuelt7examen2;

public class DatosPersonaLista {

    private int _id;
    private int avatar;
    private String nombre;
    private String telefono;

    public DatosPersonaLista(int id, int avatar, String nombre, String telefono) {
        this._id = id;
        this.avatar = avatar;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int get_id() {
        return _id;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
