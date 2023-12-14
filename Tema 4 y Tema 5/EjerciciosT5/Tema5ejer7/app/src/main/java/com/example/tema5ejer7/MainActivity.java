package com.example.tema5ejer7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        Animales[] animal = new Animales[9];
        animal[0]= new Animales(R.drawable.buho,"buho");
        animal[1]= new Animales(R.drawable.cachorros,"cachorros");
        animal[2]= new Animales(R.drawable.cerdo,"cerdo");
        animal[3]= new Animales(R.drawable.jirafas,"jirafas");
        animal[4]= new Animales(R.drawable.lobo,"lobo");
        animal[5]= new Animales(R.drawable.potro,"potro");
        animal[6]= new Animales(R.drawable.tigre,"tigre");
        animal[7]= new Animales(R.drawable.tortuga,"tortuga");
        animal[8]= new Animales(R.drawable.tucan,"tucan");

        GridView listado = findViewById(R.id.miLista);
        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(this,animal);
        listado.setAdapter(miAdaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Has seleccionado: "+((Animales) adapterView.getItemAtPosition(i)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}