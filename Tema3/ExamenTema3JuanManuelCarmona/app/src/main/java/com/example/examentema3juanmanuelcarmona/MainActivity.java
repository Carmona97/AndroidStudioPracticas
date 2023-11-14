package com.example.examentema3juanmanuelcarmona;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
        //actividad3();
    }

    public void actividad1(){
        setContentView(R.layout.activity_main);
        final EditText usuario = findViewById(R.id.user);
        final EditText passwd = findViewById(R.id.pass);
        final Button acceder = findViewById(R.id.acceder);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                acceder.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String nombreUsuario = usuario.getText().toString();
                        String contrasenaUsuario = passwd.getText().toString();
                        if((nombreUsuario.isEmpty() && contrasenaUsuario.isEmpty())){
                            Toast.makeText(MainActivity.this, "No se han introducido ni usuario ni contraseña", Toast.LENGTH_SHORT).show();
                        } else if (nombreUsuario.isEmpty()) {
                            Toast.makeText(MainActivity.this, "No se ha introducido nombre de usuario", Toast.LENGTH_SHORT).show();
                        } else if (contrasenaUsuario.isEmpty()) {
                            Toast.makeText(MainActivity.this, "No se ha introducido contraseña", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Hola "+nombreUsuario+ ", accediendo a la app" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        },3000);




    }

    public void actividad2(){
        setContentView(R.layout.activity2);
        final Button peso = findViewById(R.id.peso);
        final Button fuerte = findViewById(R.id.fuerza);
        final Button forma = findViewById(R.id.forma);
        final Button siguiente = findViewById(R.id.siguiente);
        peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peso.setBackgroundColor(rgb(243,230,248));
                fuerte.setBackgroundColor(rgb(247,193,234));
                forma.setBackgroundColor(rgb(247,193,234));
            }
        });
        fuerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fuerte.setBackgroundColor(rgb(243,230,248));
                peso.setBackgroundColor(rgb(247,193,234));
                forma.setBackgroundColor(rgb(247,193,234));
            }
        });
        forma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fuerte.setBackgroundColor(rgb(247,193,234));
                peso.setBackgroundColor(rgb(247,193,234));
                forma.setBackgroundColor(rgb(243,230,248));
            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void actividad3() {
        setContentView(R.layout.activity3);

        Spinner miSpinner = (Spinner) findViewById(R.id.miSpinner);
        final TextView textoDias = findViewById(R.id.textoDias);
        String valores[] = {"1 dia", "2 dias", "3 dias", "4 dias", "5 dias", "6 dias", "7 dias"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
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