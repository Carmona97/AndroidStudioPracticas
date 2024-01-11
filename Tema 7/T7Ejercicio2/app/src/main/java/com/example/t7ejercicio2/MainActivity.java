package com.example.t7ejercicio2;

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

        Button definePrefs = findViewById(R.id.definePrefs);
        Button cargarPrefs = findViewById(R.id.recuperaPrefs);

        definePrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent preferencias = new Intent(MainActivity.this,PreferenciasActividad.class);
                startActivity(preferencias);
            }
        });

        cargarPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                Log.i("Preferencias","Opcion 1: "+prefs.getBoolean("unicoSO",false));
                Log.i("Preferencias","Opcion 2: "+prefs.getString("elegirSO",""));
                Log.i("Preferencias","Opcion 3: "+prefs.getString("elegirVersion",""));
            }
        });
    }
}