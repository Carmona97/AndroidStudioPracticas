package com.example.tema5ejer5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter<Datos> {

    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos){
        super(context,R.layout.contenido,datos);
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.contenido,parent,false);

        TextView texto1 = elemento.findViewById(R.id.nombre);
        texto1.setText(datos[position].getNombre());

        TextView texto2 = elemento.findViewById(R.id.telefono);
        texto2.setText(datos[position].getTelefono());

        return elemento;
    }
}
