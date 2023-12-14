package com.example.ejemplolistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        // Llamada a la función para configurar el ListView
        setupListView();

        // Llamada a la función para configurar el GridView
        // setupGridView();
    }

    private void setupListView() {
        // Recupero el elemento del layout y defino los valores del listado
        final ListView listaOpciones = findViewById(R.id.listaOpciones);
        String[] datos = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"};

        // Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);

        // Asigno el adaptador
        listaOpciones.setAdapter(adaptador);

        // Defino el evento de clic para el ListView
        listaOpciones.setOnItemClickListener((listado, view, position, id) -> {
            // Muestra el elemento del listado
            Toast.makeText(MainActivity.this, "Has hecho click en: " + listado.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        });
    }

}
