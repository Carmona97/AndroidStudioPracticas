package com.principal.t7ejercicio7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Usuarios extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE IF NOT EXISTS Usuarios(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,apellido TEXT)";
    String sqlDelete = "DROP TABLE IF EXISTS Usuarios";

    public Usuarios(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlDelete);
        db.execSQL(sqlCreate);
    }
}
