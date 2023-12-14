package com.example.tema5ejer8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends ArrayAdapter<Dispositivo> {
    private ArrayList<Dispositivo> dispositivos;

    public AdaptadorPersonalizado(Context context, ArrayList<Dispositivo> dispositivos) {
        super(context,R.layout.contenidolista,dispositivos);
        this.dispositivos = dispositivos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View vista = mostrado.inflate(R.layout.contenidolista,parent,false);
        CheckBox checkLista = vista.findViewById(R.id.chkLista);
        ImageView imagenLista = vista.findViewById(R.id.imgLista);
        imagenLista.setImageResource(dispositivos.get(position).getImagen());
        TextView textoLista = vista.findViewById(R.id.textoLista);
        textoLista.setText(dispositivos.get(position).getTexto());
        return vista;
    }
}
