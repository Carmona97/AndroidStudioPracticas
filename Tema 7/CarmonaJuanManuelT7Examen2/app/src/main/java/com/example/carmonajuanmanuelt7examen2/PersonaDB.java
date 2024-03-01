package com.example.carmonajuanmanuelt7examen2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersonaDB extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Personas(_id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, telefono TEXT, avatar INTEGER)";
    String sqlDelete = "DELETE FROM Personas";


    public PersonaDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(sqlDelete);
        db.execSQL(sqlCreate);
    }
}
