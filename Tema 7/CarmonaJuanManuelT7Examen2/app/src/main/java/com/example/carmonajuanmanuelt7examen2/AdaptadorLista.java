package com.example.carmonajuanmanuelt7examen2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {
    private ArrayList<DatosPersonaLista> datosPersonas;
    private Context contexto;

    public AdaptadorLista(Context contexto, ArrayList<DatosPersonaLista> datosPersonas){
        super();
        this.contexto = contexto;
        this.datosPersonas = datosPersonas;
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

        TextView nombre = (TextView) elemento.findViewById(R.id.txtListaNombre);
        nombre.setText(datosPersonas.get(position).getNombre());

        TextView telefono = (TextView) elemento.findViewById(R.id.txtListaTelefono);
        telefono.setText(datosPersonas.get(position).getTelefono());

        return elemento;
    }
}
