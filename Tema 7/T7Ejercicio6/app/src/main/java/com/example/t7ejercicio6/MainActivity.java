package com.example.t7ejercicio6;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner miSpinner = findViewById(R.id.miSpinner);
        Vengador batman = new Vengador(R.drawable.batman);
        Vengador capi = new Vengador(R.drawable.capi);
        Vengador deadpool = new Vengador(R.drawable.deadpool);
        Vengador furia = new Vengador(R.drawable.furia);
        Vengador hulk = new Vengador(R.drawable.hulk);
        Vengador ironman = new Vengador(R.drawable.ironman);
        Vengador lobezno = new Vengador(R.drawable.lobezno);
        Vengador spiderman = new Vengador(R.drawable.spiderman);
        Vengador thor = new Vengador(R.drawable.thor);
        Vengador wonderwoman = new Vengador(R.drawable.wonderwoman);

        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnCargar = findViewById(R.id.btnRecuperar);
        Button btnBorrar = findViewById(R.id.btnBorrar);

        ImageView verVengador = findViewById(R.id.mostrarVengador);

        ArrayList<Vengador> vengadores = new ArrayList<>();

        vengadores.add(batman);
        vengadores.add(capi);
        vengadores.add(deadpool);
        vengadores.add(furia);
        vengadores.add(hulk);
        vengadores.add(ironman);
        vengadores.add(lobezno);
        vengadores.add(spiderman);
        vengadores.add(thor);
        vengadores.add(wonderwoman);

        Adaptador miAdaptador = new Adaptador(vengadores, this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int position, long id) {
                boolean sdDisponible = false;
                boolean sdAccesoEscritura = false;

                //Comprobamos el estado de la memoria sd

                String estado = Environment.getExternalStorageState();
                if (estado.equals(Environment.MEDIA_MOUNTED)) {
                    sdDisponible = true;
                    sdAccesoEscritura = true;
                } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
                    sdDisponible = true;
                }
                if(sdDisponible && sdAccesoEscritura){
                    File rutaSD = getExternalFilesDir(null);
                    File ficheroTexto = new File(rutaSD.getAbsolutePath(),"rutaVengadores.txt");
                    btnGuardar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int seleccionado = ((Vengador) adaptador.getItemAtPosition(position)).getImagen();
                            try {
                                OutputStreamWriter escribirEnFichero = new OutputStreamWriter(new FileOutputStream(ficheroTexto));
                                escribirEnFichero.write(seleccionado);
                                escribirEnFichero.close();
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });

                    btnCargar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            try {
                                File rutaSD = getExternalFilesDir(null);
                                File leerDelFichero = new File(rutaSD.getAbsolutePath(),"rutaVengadores.txt");

                                ArrayList<String> imagenesLista = new ArrayList<>();

                                BufferedReader leerDatos = new BufferedReader(new InputStreamReader(new FileInputStream(leerDelFichero),"UTF-8"));

                                String linea;
                                while ((linea = leerDatos.readLine()) != null) {
                                    if (!linea.isEmpty()) {
                                        imagenesLista.add(linea);
                                    }
                                }


                                leerDatos.close();

                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}