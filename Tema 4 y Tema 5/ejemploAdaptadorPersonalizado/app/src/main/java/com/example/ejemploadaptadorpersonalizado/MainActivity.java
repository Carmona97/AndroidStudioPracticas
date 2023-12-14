package com.example.ejemploadaptadorpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creo los datos que voy a mostrar en pantalla
        Datos[] datos = new Datos[]{
          new Datos("Línea superior 1", "Línea inferior 1"),
          new Datos("Línea superior 2", "Línea inferior 2"),
          new Datos("Línea superior 3", "Línea inferior 3"),
          new Datos("Línea superior 4", "Línea inferior 4")
        };

        // Instancio el objeto ListView
        ListView listado = findViewById(R.id.miLista);

        // Incorporo la cabecera
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listado.addHeaderView(miCabecera);

        // Creo el adaptador
        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);

        // Creo el manejador de eventos
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccionado = ((Datos) adapterView.getItemAtPosition(i)).getTexto1();
                Toast.makeText(MainActivity.this, "Has pulsado " + seleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}