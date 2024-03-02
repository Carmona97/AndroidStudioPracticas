package com.example.carmonajuanmanuelt7examen2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static int avatarSeleccionado = 0;
    static int contactoSeleccionado = 0;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucontextual,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        final Button modificar = findViewById(R.id.btnModificar);
        final ListView listaContactos = findViewById(R.id.listaContactos);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        DatosPersonaLista contacto = (DatosPersonaLista) listaContactos.getItemAtPosition(index);
        contactoSeleccionado = contacto.get_id();


        switch (item.getTitle().toString()) {
            case "BORRAR":
                ContentResolver miContentResolver = getContentResolver();
                miContentResolver.delete(ContentProvider.CONTENT_URI, ContentProvider.Personas._ID + "=" + contactoSeleccionado, null);
                listarContactos(listaContactos);
                return true;
            case "ACTUALIZAR":
                modificar.setVisibility(View.VISIBLE);
                listarContactos(listaContactos);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etBuscador = findViewById(R.id.etBuscador);
        final ImageButton anadirContacto = findViewById(R.id.btnAnadirNuevoContacto);

        final LinearLayout datosPersonaLayout = findViewById(R.id.layoutDatosPersona);
        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etTelefono = findViewById(R.id.etTelefono);
        final Spinner miSpinner = findViewById(R.id.miSpinner);

        final GridLayout zonaBotones = findViewById(R.id.zonaBotones);
        final Button agregar = findViewById(R.id.btnAgregar);
        final Button modificar = findViewById(R.id.btnModificar);
        final Button cancelar = findViewById(R.id.btnCancelar);

        final ListView listaContactos = findViewById(R.id.listaContactos);

        PersonaDB personaDB = new PersonaDB(this,"DBPersonas",null,1);
        SQLiteDatabase db = personaDB.getWritableDatabase();

        ArrayList<DatosPersonaSpinner> datosPersonaS = new ArrayList<DatosPersonaSpinner>();
        AdaptadorSpinner adaptador = new AdaptadorSpinner(datosPersonaS, this);

        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.batman));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.capi));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.deadpool));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.furia));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.hulk));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.ironman));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.lobezno));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.spiderman));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.thor));
        datosPersonaS.add(new DatosPersonaSpinner(R.drawable.wonderwoman));
        miSpinner.setAdapter(adaptador);

        listarContactos(listaContactos);
        registerForContextMenu(listaContactos);

        anadirContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datosPersonaLayout.setVisibility(View.VISIBLE);
                zonaBotones.setVisibility(View.VISIBLE);
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNombre.setText("");
                etTelefono.setText("");

                datosPersonaLayout.setVisibility(View.GONE);
                zonaBotones.setVisibility(View.GONE);
            }
        });

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DatosPersonaSpinner elementoSeleccionado = (DatosPersonaSpinner) miSpinner.getItemAtPosition(position);
                avatarSeleccionado = elementoSeleccionado.getAvatar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues value = new ContentValues();
                value.put(ContentProvider.Personas.COL_NOMBRE, etNombre.getText().toString());
                value.put(ContentProvider.Personas.COL_TELEFONO, etTelefono.getText().toString());
                value.put(ContentProvider.Personas.COL_AVATAR, avatarSeleccionado);

                ContentResolver miContentResolver = getContentResolver();
                miContentResolver.insert(ContentProvider.CONTENT_URI, value);
                etNombre.setText("");
                etTelefono.setText("");
                listarContactos(listaContactos);
            }
        });

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ContentProvider.Personas.COL_AVATAR, avatarSeleccionado);
                values.put(ContentProvider.Personas.COL_NOMBRE, etNombre.getText().toString());
                values.put(ContentProvider.Personas.COL_TELEFONO, etTelefono.getText().toString());

                ContentResolver miContentResolver = getContentResolver();
                miContentResolver.update(ContentProvider.CONTENT_URI, values,ContentProvider.Personas._ID + "=" + contactoSeleccionado, null);
                etNombre.setText("");
                etTelefono.setText("");

                listarContactos(listaContactos);
                modificar.setVisibility(View.GONE);
            }
        });



    }

    private void listarContactos(ListView listaContactos) {
        String[] columnas = new String[]{ContentProvider.Personas._ID, ContentProvider.Personas.COL_AVATAR, ContentProvider.Personas.COL_NOMBRE, ContentProvider.Personas.COL_TELEFONO,};

        Uri uriContactos = ContentProvider.CONTENT_URI;
        ContentResolver contentResolver = getContentResolver();
        Cursor miCursor = contentResolver.query(uriContactos, columnas, null, null, null);

        ArrayList<DatosPersonaLista> listaDatos = new ArrayList<DatosPersonaLista>();
        AdaptadorLista adaptador = new AdaptadorLista(this, listaDatos);

        if (miCursor != null) {
            if (miCursor.moveToFirst()) {
                int indiceId = miCursor.getColumnIndex(ContentProvider.Personas._ID);
                int indiceAvatar = miCursor.getColumnIndex(ContentProvider.Personas.COL_AVATAR);
                int indiceNombre = miCursor.getColumnIndex(ContentProvider.Personas.COL_NOMBRE);
                int indiceTelefono = miCursor.getColumnIndex(ContentProvider.Personas.COL_TELEFONO);

                do {
                    int _id = miCursor.getInt(indiceId);
                    int avatar = miCursor.getInt(indiceAvatar);
                    String nombre = miCursor.getString(indiceNombre);
                    String telefono = miCursor.getString(indiceTelefono);

                    DatosPersonaLista datosPersonaLista = new DatosPersonaLista(_id,avatar,nombre,telefono);
                    listaDatos.add(datosPersonaLista);

                } while (miCursor.moveToNext());
            }

            miCursor.close();
        }

        listaContactos.setAdapter(adaptador);
    }
}