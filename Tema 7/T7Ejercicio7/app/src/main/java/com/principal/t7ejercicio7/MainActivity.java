package com.principal.t7ejercicio7;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout mostrarActualizarYBorrar = findViewById(R.id.actualizarYBorrar);

        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etApellido = findViewById(R.id.etApellido);
        final EditText etCodigo = findViewById(R.id.etCodigo);

        final Button btnInsertar = findViewById(R.id.btnInsertar);

        final Button btnActBorr  = findViewById(R.id.btnActBorrar);
        final Button btnBorrar = findViewById(R.id.btnBorrar);
        final Button btnActualizar = findViewById(R.id.btnActualizar);

        final Button btnConsulta = findViewById(R.id.btnConsulta);

        final TextView textoConsulta = findViewById(R.id.verRegistros);

        Usuarios usuario = new Usuarios(this,"DBUsuarios",null,1);
        SQLiteDatabase db = usuario.getWritableDatabase();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario;
                String apellidoUsuario;
                nombreUsuario = etNombre.getText().toString();
                apellidoUsuario = etApellido.getText().toString();

                ContentValues registro = new ContentValues();
                registro.put("nombre", nombreUsuario);
                registro.put("apellido",apellidoUsuario);
                db.insert("Usuarios",null,registro);

                etNombre.setText("");
                etApellido.setText("");

                Toast.makeText(MainActivity.this, "Se ha insertado "+nombreUsuario+" "+apellidoUsuario, Toast.LENGTH_SHORT).show();

            }
        });

        btnActBorr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mostrarActualizarYBorrar.getVisibility() == View.VISIBLE){
                    mostrarActualizarYBorrar.setVisibility(View.GONE);
                }else{
                    mostrarActualizarYBorrar.setVisibility(View.VISIBLE);
                }
            }
        });

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor miCursor = db.rawQuery("SELECT * FROM Usuarios;", null);

                textoConsulta.setText("");

                if(miCursor.moveToFirst()){
                    do{
                        String cod = String.valueOf(miCursor.getInt(0));
                        String nombre = miCursor.getString(1);
                        String apellido = miCursor.getString(2);

                        textoConsulta.append(cod+" "+nombre+" "+apellido+"\n");
                    }while(miCursor.moveToNext());
                    miCursor.close();
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String codigo = etCodigo.getText().toString();
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String[] args = {codigo};

                db.execSQL("UPDATE Usuarios SET nombre='" + nombre + "', apellido='" + apellido + "' WHERE codigo = ?", args);

                Toast.makeText(MainActivity.this, "Se ha modificado el usuario con codigo "+ codigo, Toast.LENGTH_SHORT).show();
                etCodigo.setText("");
                etApellido.setText("");
                etNombre.setText("");
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = etCodigo.getText().toString();

                db.execSQL("DELETE FROM Usuarios WHERE codigo="+codigo);
                etCodigo.setText("");


                Toast.makeText(MainActivity.this, "Se ha eliminado al usuario con codigo "+codigo , Toast.LENGTH_SHORT).show();
            }
        });

    }
}