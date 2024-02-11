package com.principal.pruebapreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button cambiar = findViewById(R.id.cambiarPreferencias);
        final Button ver = findViewById(R.id.verPreferencias);

        cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent preferencias = new Intent(MainActivity.this,Preferencias.class);
                startActivity(preferencias);
            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                Log.i("saludo"," "+prefs.getBoolean("saludo",false));
                Log.i("language",prefs.getString("language",""));
                Log.i("recomendacion",prefs.getString("recomendacion",""));
            }
        });
    }
}