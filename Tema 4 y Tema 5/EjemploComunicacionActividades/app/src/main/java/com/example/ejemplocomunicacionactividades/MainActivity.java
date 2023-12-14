package com.example.ejemplocomunicacionactividades;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Obtengo el label del resultado
        final TextView lblResultado = (TextView) findViewById(R.id.lblResultado);

        // Recogemos los datos de la actividad 2
        // No escribir este código en la primera parte del ejercicio, añadir al final
        ActivityResultLauncher resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent intent = result.getData();
                            if (intent!=null){
                                Bundle extras = intent.getExtras();
                                String resultado = extras.getString("boton_pulsado");
                                lblResultado.append(resultado);
                            }
                        }
                    }
                });



        // Obtengo la información al pulsar el botón
        final EditText etNombre = (EditText) findViewById(R.id.etNombre);
        final Button btnVerificar = (Button) findViewById(R.id.btnVerificar);
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etNombre.getText().toString();

                Intent intent_condiciones = new Intent(MainActivity.this,CondicionesUso.class);
                intent_condiciones.putExtra("usuario",usuario);
                // Usar en la primera parte del ejercicio. Quitar cuando se manden ejercicio de la segunda actividad
                //startActivity(intent_condiciones);
                resultLauncher.launch(intent_condiciones);

            }
        });

    }


}