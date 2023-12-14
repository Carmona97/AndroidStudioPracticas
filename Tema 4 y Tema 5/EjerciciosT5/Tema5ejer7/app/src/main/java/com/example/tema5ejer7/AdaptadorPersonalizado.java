package com.example.tema5ejer7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorPersonalizado extends BaseAdapter {
    private Animales[] animal;
    private Context context;

    public AdaptadorPersonalizado(Context context, Animales[] animal) {
        super();
        this.context = context;
        this.animal = animal;
    }

    public Animales[] getAnimal() {
        return animal;
    }

    public void setAnimal(Animales[] animal) {
        this.animal = animal;
    }

    @Override
    public int getCount() {
        return animal.length;
    }

    @Override
    public Object getItem(int i) {
        return animal[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(context);
        View elemento = mostrado.inflate(R.layout.animallayout,parent,false);
        TextView texto =elemento.findViewById(R.id.miTexto1);
        texto.setText(animal[i].getNombre());
        ImageView imagen = elemento.findViewById(R.id.imagen);
        imagen.setImageResource(animal[i].getImagen());
        return elemento;
    }
}
