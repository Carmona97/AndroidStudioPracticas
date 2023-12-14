package com.example.tema5ejer8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dispositivo tele = new Dispositivo(false,R.drawable.tv,"la television");
        Dispositivo movil = new Dispositivo(false,R.drawable.smartphone,"el smartphone");
        Dispositivo tablet = new Dispositivo(false,R.drawable.tablet,"la tablet");
        Dispositivo pc = new Dispositivo(false,R.drawable.ordenador_fijo,"el ordenador de sobremesa");
        Dispositivo portatil = new Dispositivo(false,R.drawable.ordenador_portatil,"el portatil");
        Dispositivo reloj = new Dispositivo(false,R.drawable.reloj,"el reloj");

        ArrayList <Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.add(tele);
        dispositivos.add(movil);
        dispositivos.add(tablet);
        dispositivos.add(pc);
        dispositivos.add(portatil);
        dispositivos.add(reloj);

        View cabecera = getLayoutInflater().inflate(R.layout.header,null);
        View contenidoLista = getLayoutInflater().inflate(R.layout.contenidolista,null);

        ListView miLista = findViewById(R.id.miLista);
        miLista.addHeaderView(cabecera);
        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(this,dispositivos);
        miLista.setAdapter(miAdaptador);

        CheckBox chkLista = contenidoLista.findViewById(R.id.chkLista);
        Button btnAceptar = cabecera.findViewById(R.id.btnCabecera);



        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seleccionados = "";
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.isCheckbox()) {
                        seleccionados += dispositivo.getTexto() + " ";
                    }
                }

                if (!seleccionados.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Dispositivos seleccionados: " + seleccionados, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Ningún dispositivo seleccionado.", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}