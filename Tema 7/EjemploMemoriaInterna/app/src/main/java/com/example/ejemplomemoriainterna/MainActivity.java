package com.example.ejemplomemoriainterna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Escribo en memoria interna del dispositivo

        try{
            OutputStreamWriter mifichero = new OutputStreamWriter(openFileOutput("fichero.txt",MODE_PRIVATE));
            mifichero.write("Texto de prueba");
            mifichero.close();
        }catch (Exception e){
            Log.e("Ficheros","Error al escribir en memoria interna");
        }

        // Recupero la informacion de memoria interna

        try {

            BufferedReader leerMiFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
            String texto = leerMiFichero.readLine();
            leerMiFichero.close();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Log.e("Ficheros","Error al leer de memoria interna");
        }

    }
}