package com.example.carmonajuanmanuelt7examen2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {

    private ArrayList<DatosPersonaSpinner> datosPersonas;
    Context contexto;

    public AdaptadorSpinner(ArrayList<DatosPersonaSpinner> datosPersonas, Context contexto) {
        this.datosPersonas = datosPersonas;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return datosPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return datosPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.layout_lista, parent, false);

        ImageView avatar = elemento.findViewById(R.id.imgListaAvatar);
        avatar.setImageResource(datosPersonas.get(position).getAvatar());

        return elemento;
    }
}
