package com.example.t7ejercicio6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Vengador> vengadores;
    private Context contexto;

    public Adaptador(ArrayList<Vengador> vengadores, Context contexto) {
        this.vengadores = vengadores;
        this.contexto = contexto;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento,parent, false );
        ImageView imagen = elemento.findViewById(R.id.imagenFinal);
        imagen.setImageResource(vengadores.get(posicion).getImagen());

        return elemento;
    }

    @Override
    public int getCount(){
        return vengadores.size();
    }

    @Override
    public Object getItem(int posicion){
        return vengadores.get(posicion);
    }

    @Override
    public long getItemId(int posicion){
        return posicion;
    }
}
