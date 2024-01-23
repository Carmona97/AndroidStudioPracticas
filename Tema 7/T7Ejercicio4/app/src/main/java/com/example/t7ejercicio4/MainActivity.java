package com.example.t7ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnGuardar = findViewById(R.id.guardar);
        final Button btnRecuperar = findViewById(R.id.recuperar);
        final EditText textoEscrito = findViewById(R.id.IntroduceTexto);
        final TextView verTexto = findViewById(R.id.verTexto);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    OutputStreamWriter mifichero = new OutputStreamWriter(openFileOutput("fichero.txt",MODE_PRIVATE));
                    String guardarMemoria = textoEscrito.getText().toString();
                    mifichero.write(guardarMemoria);
                    mifichero.close();
                }catch (Exception e){
                    Log.e("Ficheros","Error al escribir en memoria interna");
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    BufferedReader leerMiFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
                    String texto = leerMiFichero.readLine();
                    leerMiFichero.close();
                    verTexto.setText(texto);

                }catch (Exception e){
                    Log.e("Ficheros","Error al leer de memoria interna");
                }
            }
        });
    }
}