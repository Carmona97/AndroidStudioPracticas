package com.example.ejemploalmacenarcomorecurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            InputStream fraw = getResources().openRawResource(R.raw.prueba_raw);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

            String linea = brin.readLine();
            Log.i("Ficheros",linea);
            fraw.close();

        }catch(Exception e){
            Log.i("Ficheros","Error al leer desde recurso");
        }
    }
}