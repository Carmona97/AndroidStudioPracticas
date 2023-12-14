package com.example.proyectot45;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPantalla2 extends ArrayAdapter<ElementosPantalla2> {

    private ArrayList <ElementosPantalla2> juegosDeMesa;

    public AdaptadorPantalla2(Context context, ArrayList<ElementosPantalla2> juegosDeMesa) {
        super(context,R.layout.elementosgrid_pantalla2,juegosDeMesa);
        this.juegosDeMesa = juegosDeMesa;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View vista = mostrado.inflate(R.layout.elementosgrid_pantalla2,parent,false);

        ImageView imagen = vista.findViewById(R.id.imagen);
        TextView textoJuego = vista.findViewById(R.id.textoJuego);
        Button resena = vista.findViewById(R.id.resena);


        imagen.setImageResource(juegosDeMesa.get(position).getImagen());
        textoJuego.setText(juegosDeMesa.get(position).getTextoJuego());

        resena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = juegosDeMesa.get(position).getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(intent);
            }
        });

        return vista;
    }
}
