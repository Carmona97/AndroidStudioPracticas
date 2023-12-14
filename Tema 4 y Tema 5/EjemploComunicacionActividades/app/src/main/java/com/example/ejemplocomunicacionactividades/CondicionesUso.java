package com.example.ejemplocomunicacionactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CondicionesUso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condicionesuso);

        TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);

        // Obtengo la información del intent
        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");

        // Muestro el saludo en la etiqueta
        String mensaje = "Hola " + usuario + ". ¿Aceptas las condiciones?";
        lblMensaje.setText(mensaje);
    }

    public void onClick(View view){

        Intent intent = new Intent();

        // Comprobamos qué Vista (botón) ha invocado el método
        switch (view.getId()){
            case R.id.btnAceptar:
                intent.putExtra("boton_pulsado","Aceptar");
                setResult(RESULT_OK,intent);
                break;

            case R.id.btnRechazar:
                intent.putExtra("boton_pulsado","Rechazar");
                setResult(RESULT_OK,intent);
                break;
        }

        finish();
    }
}