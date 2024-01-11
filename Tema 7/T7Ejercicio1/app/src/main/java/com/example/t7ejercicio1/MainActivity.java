package com.example.t7ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombre = findViewById(R.id.etNombre);
        EditText apellidos = findViewById(R.id.etApellidos);
        Button guardar = findViewById(R.id.btnGuardar);
        Button cargar = findViewById(R.id.btnCargar);
        TextView mostrarNombre = findViewById(R.id.nombreTxt);
        TextView mostrarApellidos = findViewById(R.id.apellidosTxt);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nombre",nombre.getText().toString());
                editor.putString("apellidos",apellidos.getText().toString());
                editor.commit();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
                String nombre = prefs.getString("nombre","");
                String apellidos = prefs.getString("apellidos","");

                mostrarNombre.setText("Nombre: "+nombre);
                mostrarApellidos.setText("Apellidos: "+apellidos);
            }
        });
    }
}