package com.example.ejemplobaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Datos> datos;
    private Context contexto;

    public Adaptador(Context contexto, ArrayList<Datos> datos){
        super();
        this.contexto = contexto;
        this.datos = datos;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup parent){

        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);
        TextView texto1 = (TextView) elemento.findViewById(R.id.miTexto1);
        texto1.setText(datos.get(posicion).getTexto1());
        TextView texto2 = (TextView) elemento.findViewById(R.id.miTexto2);
        texto2.setText(datos.get(posicion).getTexto2());

        return elemento;
    }

    @Override
    public int getCount(){
        return datos.size();
    }

    @Override
    public Object getItem(int posicion){
        return datos.get(posicion);
    }

    @Override
    public long getItemId(int posicion){
        return posicion;
    }
}
