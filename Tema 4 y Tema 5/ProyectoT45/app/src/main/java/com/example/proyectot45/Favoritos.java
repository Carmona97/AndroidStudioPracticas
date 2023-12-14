package com.example.proyectot45;

import static android.graphics.Color.rgb;
import static com.example.proyectot45.Pantalla2.juegosDeMesa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Favoritos extends AppCompatActivity {

    ListView miLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        miLista = findViewById(R.id.listaFavoritos);
        String[] nombresJuegos = new String[7];
        int posicionArray = 0;
        for (ElementosPantalla2 i:
             juegosDeMesa) {
            nombresJuegos[posicionArray] = i.getTextoJuego();
            posicionArray++;
        }


        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombresJuegos);
        miLista.setAdapter(adaptador);
        registerForContextMenu(miLista);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        String seleccionado = (String) item.getTitle();

        switch (seleccionado){
            case "Contacta con nosotros":
                llamarTelefono(miLista);
                return true;
            case "ASMODEE":
                abrirPagina(miLista, "https://asmodee.es/");
                return true;
            case "MULLIGAN":
                abrirPagina(miLista, "https://tiendamulligan.com/");
                return true;
            case "ZACATRUS":
                abrirPagina(miLista, "https://zacatrus.es/");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String seleccion = (String) item.getTitle();
        switch (seleccion) {
            case "Añadir como favorito":
                cambiarColorFondo(info.position, rgb(232,179,75));
                return true;
            case "Eliminar como favorito":
                cambiarColorFondo(info.position, Color.WHITE);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private View getViewByPosition(int position, ListView listView) {
        int primerElemento = listView.getFirstVisiblePosition();
        int ultimoElemento = primerElemento + listView.getChildCount() - 1;

        if (position < primerElemento || position > ultimoElemento) {
            return null;
        } else {
            int elementoSeleccionado = position - primerElemento;
            return listView.getChildAt(elementoSeleccionado);
        }
    }

    private void cambiarColorFondo(int posicion, int color) {
        View view = getViewByPosition(posicion, miLista);
        if (view != null) {
            view.setBackgroundColor(color);
        }
    }

    public void llamarTelefono(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:000000000"));
        startActivity(intent);
    }

    public void abrirPagina(View view,String urlTienda){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlTienda));
        startActivity(intent);
    }


}