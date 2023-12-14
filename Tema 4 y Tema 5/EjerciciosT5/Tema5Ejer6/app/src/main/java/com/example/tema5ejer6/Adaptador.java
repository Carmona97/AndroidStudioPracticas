package com.example.tema5ejer6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class Adaptador extends ArrayAdapter<Datos> {

    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos) {
        super(context, R.layout.elementos,datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elementos,parent,false);

        ImageView imagen = elemento.findViewById(R.id.imagen);
        imagen.setImageResource(datos[position].getImagen());

        TextView titulo = elemento.findViewById(R.id.titulo);
        titulo.setText(datos[position].getTitulo());

        TextView texto = elemento.findViewById(R.id.contenido);
        texto.setText(datos[position].getTexto());

        return elemento;
    }
}
