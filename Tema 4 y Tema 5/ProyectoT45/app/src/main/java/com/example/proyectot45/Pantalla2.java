package com.example.proyectot45;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla2 extends AppCompatActivity {

    static ArrayList<ElementosPantalla2> juegosDeMesa = new ArrayList<ElementosPantalla2>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        GridView miGrid = findViewById(R.id.miGrid);
        Button favoritos = findViewById(R.id.favoritos);

        juegosDeMesa.add(new ElementosPantalla2(R.drawable.maltrago,"MAL TRAGO","https://jugadorinicial.com/es/resenas/mal-trago-2/"));
        juegosDeMesa.add(new ElementosPantalla2(R.drawable.dixit,"DIXIT","https://misutmeeple.com/2015/06/resena-dixit/"));
        juegosDeMesa.add(new ElementosPantalla2(R.drawable.gatosexplosivos,"EXPLODING KITTENS","https://muevecubos.com/blog/resena-exploding-kittens/"));
        juegosDeMesa.add(new ElementosPantalla2(R.drawable.happysalmon,"HAPPY SALMON","https://misutmeeple.com/2017/04/resena-happy-salmon/"));
        juegosDeMesa.add(new ElementosPantalla2(R.drawable.mantis,"MANTIS","https://asmodee.es/5-razones-de-peso-para-jugar-a-mantis/"));
        juegosDeMesa.add(new ElementosPantalla2(R.drawable.maravillas7,"7 WONDERS","https://misutmeeple.com/2013/02/resena-7-wonders/"));
        juegosDeMesa.add(new ElementosPantalla2(R.drawable.islaprohibida,"ISLA PROHIBIDA","https://garesys.com/blog/la-isla-prohibida/"));

        AdaptadorPantalla2 miAdaptador = new AdaptadorPantalla2(this,juegosDeMesa);
        miGrid.setAdapter(miAdaptador);

        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pantalla2.this, Favoritos.class);
                startActivity(intent);
            }
        });

    }
}