package com.example.t7ejercicio6;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner miSpinner = findViewById(R.id.miSpinner);
        Vengador batman = new Vengador(R.drawable.batman);
        Vengador capi = new Vengador(R.drawable.capi);
        Vengador deadpool = new Vengador(R.drawable.deadpool);
        Vengador furia = new Vengador(R.drawable.furia);
        Vengador hulk = new Vengador(R.drawable.hulk);
        Vengador ironman = new Vengador(R.drawable.ironman);
        Vengador lobezno = new Vengador(R.drawable.lobezno);
        Vengador spiderman = new Vengador(R.drawable.spiderman);
        Vengador thor = new Vengador(R.drawable.thor);
        Vengador wonderwoman = new Vengador(R.drawable.wonderwoman);

        ArrayList<Vengador> vengadores = new ArrayList<>();

        vengadores.add(batman);
        vengadores.add(capi);
        vengadores.add(deadpool);
        vengadores.add(furia);
        vengadores.add(hulk);
        vengadores.add(ironman);
        vengadores.add(lobezno);
        vengadores.add(spiderman);
        vengadores.add(thor);
        vengadores.add(wonderwoman);

        Adaptador miAdaptador= new Adaptador(vengadores, this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int position, long id) {
                int seleccionado = ((Vengador) adaptador.getItemAtPosition(position)).getImagen();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}