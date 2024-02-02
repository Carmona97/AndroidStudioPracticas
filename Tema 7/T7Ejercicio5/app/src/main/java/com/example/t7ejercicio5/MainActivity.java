package com.example.t7ejercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);
        EditText etInformacion = findViewById(R.id.etInformacion);
        TextView mostrarTexto = findViewById(R.id.verTexto);

        boolean sdDisponible = false;
        boolean accesoDeEscritura = false;

        String estado = Environment.getExternalStorageState();
        if(estado.equals(Environment.MEDIA_MOUNTED)){
            sdDisponible = true;
            accesoDeEscritura = true;
        }else if(estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            sdDisponible = true;
        }

        if(sdDisponible && accesoDeEscritura){
            try{

                //Obtengo la ruta del directorio raiz

                File rutaSd = getExternalFilesDir(null);

                File f = new File(rutaSd.getAbsolutePath(),"ejercicio5.txt");
                btnGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String guardarTexto = etInformacion.getText().toString();
                            OutputStreamWriter fout = null;
                            fout = new OutputStreamWriter(new FileOutputStream(f));
                            fout.write(guardarTexto);
                            etInformacion.setText("");
                            fout.close();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    }
                });


            }catch (Exception e){
                Log.e("Ficheros","Error al escribir en la tarjeta SD");
            }

            if(sdDisponible){

                //Obtengo la ruta del directorio raiz
                    btnRecuperar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                File rutaSd = getExternalFilesDir(null);

                                File f = new File(rutaSd.getAbsolutePath(),"ejercicio5.txt");

                                BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                                String texto = fin.readLine();
                                mostrarTexto.setText(texto);
                                fin.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });

            }
        }
    }
}