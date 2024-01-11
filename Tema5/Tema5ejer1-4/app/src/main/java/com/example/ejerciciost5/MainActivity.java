package com.example.ejerciciost5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //actividad1();
        //actividad2();
        //actividad3();
        //actividad4();
        actividad5();
    }

    public void actividad1(){
        setContentView(R.layout.activity_main);

        ListView miLista = findViewById(R.id.miLista);

        String datos[] = {"Kung fu panda","Karate a muerte en Torremolinos","La bala que dobló la esquina","Una mente maravillosa","50 sombras de Grey","El alumbrado"};
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        miLista.setAdapter(adaptador);
        miLista.setOnItemClickListener((listado, view, position, id) -> {
            // Muestra el elemento del listado
            Toast.makeText(MainActivity.this, "Has hecho click en: " + listado.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        });
    }
    public void actividad2(){
        setContentView(R.layout.activity_main2);

        GridView miLista = findViewById(R.id.miLista);

        String datos[] = {"Kung fu panda","Karate a muerte en Torremolinos","La bala que dobló la esquina","Una mente maravillosa","50 sombras de Grey","El alumbrado"};
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        miLista.setAdapter(adaptador);
        miLista.setOnItemClickListener((listado, view, position, id) -> {
            // Muestra el elemento del listado
            Toast.makeText(MainActivity.this, "Has hecho click en: " + listado.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        });
    }
    public void actividad3(){
        setContentView(R.layout.activity_main3);

        GridView miLista = findViewById(R.id.miLista);

        String datos[] = {"Kung fu panda","Karate a muerte en Torremolinos","La bala que dobló la esquina","Una mente maravillosa","50 sombras de Grey","El alumbrado"};
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        miLista.setAdapter(adaptador);
        miLista.setOnItemClickListener((listado, view, position, id) -> {
            // Muestra el elemento del listado
            Toast.makeText(MainActivity.this, "Has hecho click en: " + listado.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        });
    }

    public void actividad4(){
        setContentView(R.layout.activity_main5);

        Spinner miSpinner = findViewById(R.id.miSpinner);
        TextView miTexto = findViewById(R.id.textoPelicula);

        String datos[] = {"Kung fu panda","Karate a muerte en Torremolinos","La bala que dobló la esquina","Una mente maravillosa","50 sombras de Grey","El alumbrado"};
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        miSpinner.setAdapter(adaptador);
        miSpinner.setOnItemClickListener((listado, view, position, id) -> {
            miTexto.setText("Has seleccionado: "+miSpinner.getItemAtPosition(position));
        });
    }

  /*  public void actividad5(){
        setContentView(R.layout.activity_main5);

        ListView contactos = findViewById(R.id.contactos);
        String[] datos = {"Paco","Maria","Andres","Juan","Guille","Marcos"};
        ArrayAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);
        contactos.setAdapter(adaptador);
        contactos.setOnItemClickListener((listado, view, position, id) -> Toast.makeText(this, "Has seleccionado: "+contactos.getItemAtPosition(position), Toast.LENGTH_SHORT).show());
    }*/
}

