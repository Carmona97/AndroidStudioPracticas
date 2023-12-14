package com.example.ejemplobaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Defino los datos
        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos(R.drawable.consola,"Consola"));
        datos.add(new Datos(R.drawable.ordenador_fijo,"Ordenador fijo"));
        datos.add(new Datos(R.drawable.ordenador_portatil,"Ordenador portátil"));
        datos.add(new Datos(R.drawable.reloj,"Reloj"));
        datos.add(new Datos(R.drawable.smartphone,"Smartphone"));
        datos.add(new Datos(R.drawable.tablet,"Tablet"));
        datos.add(new Datos(R.drawable.tv,"Televisión"));


        // Incorporo el objeto ListView en la aplicación
        ListView listado = (ListView) findViewById(R.id.miLista);


        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);

        // Inserto el listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View view, int position, long id) {
                String seleccionado = ((Datos) adaptador.getItemAtPosition(position)).getTexto();
            }
        });
    }
}