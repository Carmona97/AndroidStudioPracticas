package com.example.pruebadeevaluacionjuanma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);


        final Button botonValoracion = findViewById(R.id.btnValoraciones);
        final Button botonCumpleano = findViewById(R.id.btnAnadirCumpleano);
        final ImageButton botonUsuario = findViewById(R.id.btnIdentificarse);
        final EditText usuario = findViewById(R.id.txtUsuario);
        final EditText contrasena = findViewById(R.id.txtContrasena);
        final Button botonIniciarSesion = findViewById(R.id.btnIniciarSesion);

        botonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botonUsuario.setVisibility(View.INVISIBLE);
                usuario.setVisibility(View.VISIBLE);
                contrasena.setVisibility(View.VISIBLE);
                botonIniciarSesion.setVisibility(View.VISIBLE);
            }
        });

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout2);
                final EditText nombreUsuario = findViewById(R.id.nombre);
                final EditText fechaNacimiento = findViewById(R.id.fechaNacimiento);
                final TextView mostrarTexto = findViewById(R.id.txtInfo);
                final CheckBox crearRecordatorio = findViewById(R.id.chkRecordatorio);
                final Button botonAceptar = findViewById(R.id.btnAceptar);

                botonAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nombre = nombreUsuario.getText().toString();
                        String cumpleannos = fechaNacimiento.getText().toString();
                        if(nombre.isEmpty() && cumpleannos.isEmpty()){
                            mostrarTexto.setText("ERROR. No has escrito ni el nombre ni la fecha de nacimiento");
                        } else if(nombre.isEmpty()){
                            mostrarTexto.setText("ERROR. No has escrito el nombre");
                        } else if (cumpleannos.isEmpty()) {
                            mostrarTexto.setText("ERROR. No has escrito la fecha de nacimiento");
                        } else if (crearRecordatorio.isChecked()) {
                            mostrarTexto.setText("Se ha guardado el cumpleaños de "+nombre+" con la fecha "+cumpleannos+". El recordatorio se ha guardado con exito");
                        } else if (!crearRecordatorio.isChecked()) {
                            mostrarTexto.setText("Por favor, marque la casilla superior para registrar los datos");
                        }
                    }
                });
            }
        });



        botonCumpleano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout2);
                final EditText nombreUsuario = findViewById(R.id.nombre);
                final EditText fechaNacimiento = findViewById(R.id.fechaNacimiento);
                final TextView mostrarTexto = findViewById(R.id.txtInfo);
                final CheckBox crearRecordatorio = findViewById(R.id.chkRecordatorio);
                final Button botonAceptar = findViewById(R.id.btnAceptar);

                botonAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nombre = nombreUsuario.getText().toString();
                        String cumpleannos = fechaNacimiento.getText().toString();
                        if(nombre.isEmpty() && cumpleannos.isEmpty()){
                            mostrarTexto.setText("ERROR. No has escrito ni el nombre ni la fecha de nacimiento");
                        } else if(nombre.isEmpty()){
                            mostrarTexto.setText("ERROR. No has escrito el nombre");
                        } else if (cumpleannos.isEmpty()) {
                            mostrarTexto.setText("ERROR. No has escrito la fecha de nacimiento");
                        } else if (crearRecordatorio.isChecked()) {
                            mostrarTexto.setText("Se ha guardado el cumpleaños de "+nombre+" con la fecha "+cumpleannos+". El recordatorio se ha guardado con exito");
                        } else if (!crearRecordatorio.isChecked()) {
                            mostrarTexto.setText("Por favor, marque la casilla superior para registrar los datos");
                        }
                    }
                });
            }
        });
        botonValoracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout3);
                final RadioGroup miGrupo = findViewById(R.id.groupValoracion);
                final RatingBar puntuacion = findViewById(R.id.miRating);
                final TextView textoValoracion = findViewById(R.id.txtValoracion);

                miGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup groupValoracion, int checkedId) {
                        RadioButton botonSeleccionado = findViewById(checkedId);
                        textoValoracion.setText("Seleccionaste: " + botonSeleccionado.getText());

                        puntuacion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                textoValoracion.setText("La valoración de " + botonSeleccionado.getText() + " se ha modificado a " + rating);
                            }
                        });
                    }
                });
            }
        });

    }

}