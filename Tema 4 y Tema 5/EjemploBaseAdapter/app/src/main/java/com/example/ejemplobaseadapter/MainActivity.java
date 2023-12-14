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
        datos.add(new Datos("Línea Superior 1", "Línea Inferior 1"));
        datos.add(new Datos("Línea Superior 2", "Línea Inferior 2"));
        datos.add(new Datos("Línea Superior 3", "Línea Inferior 3"));
        datos.add(new Datos("Línea Superior 4", "Línea Inferior 4"));
        datos.add(new Datos("Línea Superior 5", "Línea Inferior 5"));


        // Incorporo el objeto ListView en la aplicación
        ListView listado = (ListView) findViewById(R.id.miLista);

        // Incorporo la cabecera
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listado.addHeaderView(miCabecera);

        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);

        // Inserto el listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View view, int position, long id) {
                String seleccionado = ((Datos) adaptador.getItemAtPosition(position)).getTexto1();
            }
        });
    }
}