package com.example.practicaexamen;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //actividad1();
        //actividad2();
        actividad3();


        }
    public void actividad1(){
        setContentView(R.layout.layout1);
        final Button botonAcceder = findViewById(R.id.accede);
        final TextView nombreuser = findViewById(R.id.user);
        final TextView passwd = findViewById(R.id.pass);

        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUserText = nombreuser.getText().toString();
                String passwdText = passwd.getText().toString();

                if (nombreUserText.isEmpty() && passwdText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No se ha introducido ningún dato", Toast.LENGTH_SHORT).show();
                } else if (nombreUserText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No se ha introducido ningún usuario", Toast.LENGTH_SHORT).show();
                } else if (passwdText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No se ha introducido contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Bienvenido a la aplicación " + nombreUserText, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void actividad2(){
        setContentView(R.layout.layout2);
        final Button peso = findViewById(R.id.peso);
        final Button fuerte = findViewById(R.id.fuerza);
        final Button forma = findViewById(R.id.forma);

        peso.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                peso.setBackgroundColor(rgb(243,230,248));
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();

            }
        });
        fuerte.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fuerte.setBackgroundColor(rgb(243,230,248));
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });
        forma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                forma.setBackgroundColor(rgb(243,230,248));
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void actividad3(){
        setContentView(R.layout.layout3);

        final GridLayout layoutCheck = findViewById(R.id.grupoCheck);
        String elementosSeleccionados = "";
        for (int i=0; i<layoutCheck.getChildCount(); i++){
            CheckBox micheck = (CheckBox) layoutCheck.getChildAt(i);
            if (micheck.isChecked()){
                elementosSeleccionados += micheck.toString()+", ";
            }
        }

        Spinner miSpinner = (Spinner) findViewById(R.id.miSpinner);
        final TextView textoDias = findViewById(R.id.textoDias);
        String valores[] = {"dia 1","dia 2","dia 3","dia 4","dia 5","dia 6","dia 7"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));
        Spinner spinner = (Spinner) findViewById(R.id.miSpinner);
        String valor = spinner.getSelectedItem().toString();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int
                    posicion, long id) {
                String valorSeleccionado = valores[posicion];
                textoDias.setText(valorSeleccionado);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


}