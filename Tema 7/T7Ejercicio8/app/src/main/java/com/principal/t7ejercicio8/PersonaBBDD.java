package com.principal.t7ejercicio8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersonaBBDD extends SQLiteOpenHelper {

    String SQLcrearTabla = "CREATE TABLE IF NOT EXISTS Persona(codigo INTEGER PRIMARY KEY AUTOINCREMENT,Nombre TEXT, Apellido TEXT);";
    String SQLBorrarTabla = "DROP TABLE IF EXISTS Persona;";

    public PersonaBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLcrearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLBorrarTabla);
        db.execSQL(SQLcrearTabla);
    }
}
