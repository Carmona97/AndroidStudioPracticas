package com.example.ejemplosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuariosBBDD extends SQLiteOpenHelper {

    // Sentencia SQL para crear la tabla de usuarios

    String sqlCreate = "CREATE TABLE Usuarios(codigo INTEGER PRIMARY KEY, nombre TEXT)";

    public UsuariosBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Ejecuta la sentencia SQL de creacion de tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //NOTA: Por simplicidad del ejemplo vamos a borrar
        // y volver a crear directamente las tablas para no tener que hacer
        // copia de seguridad de la informacion y de establecerlo

        //Se elimina la version anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        //Se crea de nuevo
        db.execSQL(sqlCreate);
    }
}
