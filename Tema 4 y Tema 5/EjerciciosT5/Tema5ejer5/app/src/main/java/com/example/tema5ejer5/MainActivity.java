package com.example.tema5ejer5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View cabecera = getLayoutInflater().inflate(R.layout.header, null);
        ListView miLista = findViewById(R.id.miLista);
        miLista.addHeaderView(cabecera);

        Datos nuevo1 = new Datos("Juanma", "633123456");
        Datos nuevo2 = new Datos("Juan", "633678956");
        Datos nuevo3 = new Datos("Paco", "633123063");
        Datos nuevo4 = new Datos("Alberto", "63317654");

        Datos[] misDatos = {nuevo1, nuevo2, nuevo3, nuevo4};
        Adaptador miAdaptador = new Adaptador(this,misDatos);
        miLista.setAdapter(miAdaptador);

        miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String seleccionado = ((Datos) adapterView.getItemAtPosition(position)).getNombre()+" "+((Datos) adapterView.getItemAtPosition(position)).getTelefono();
                Toast.makeText(MainActivity.this, "Has seleccionado "+seleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }

}