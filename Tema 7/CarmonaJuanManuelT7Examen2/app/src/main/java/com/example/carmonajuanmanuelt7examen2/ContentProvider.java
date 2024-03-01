package com.example.carmonajuanmanuelt7examen2;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

public class ContentProvider extends android.content.ContentProvider{

    public ContentProvider() {
    }

    private static final String AUTHORITY = "com.example.carmonajuanmanuelt7examen2";
    private static final String uri = "content://" + AUTHORITY + "/Personas";
    public static final Uri CONTENT_URI = Uri.parse(uri);

    private static final int PERSONAS = 1;
    private static final int PERSONAS_ID = 2;
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"Personas",PERSONAS);
        uriMatcher.addURI(AUTHORITY,"Personas/#", PERSONAS_ID);
    }

    // Clase interna para declarar las constantes de columna
    public static final class Personas implements BaseColumns {
        private Personas(){}

        public static final String COL_AVATAR = "avatar";
        public static final String COL_NOMBRE = "nombre";
        public static final String COL_TELEFONO = "telefono";

    }

    private PersonaDB personadbh;
    private static final String BD_NOMBRE = "DBPersonas";
    private static final int BD_VERSION = 1;
    private static final String TABLA_PERSONAS = "Personas";

    @Override
    public boolean onCreate() {
        personadbh = new PersonaDB(getContext(),BD_NOMBRE, null, BD_VERSION);
        Log.i("PersonaDB","Base de datos creada con exito");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String where = selection;
        if (uriMatcher.match(uri)== PERSONAS_ID){
            where = "_id=" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = personadbh.getWritableDatabase();

        Cursor miCursor = db.query(TABLA_PERSONAS, projection, where, selectionArgs, null, null, sortOrder);

        return miCursor;
    }

    @Override
    public String getType(Uri uri) {

        int match = uriMatcher.match(uri);

        switch (match){
            case PERSONAS:
                return "vnd.android.cursor.dir/vnd.example.carmonajuanmanuelt7examen2.Personas";
            case PERSONAS_ID:
                return "vnd.android.cursor.item/vnd.example.carmonajuanmanuelt7examen2.Personas";
            default:
                return null;
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        long regId;

        SQLiteDatabase db = personadbh.getWritableDatabase();

        regId = db.insert(TABLA_PERSONAS, null, contentValues);

        Uri newUri = ContentUris.withAppendedId(CONTENT_URI,regId);

        return newUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int cont;

        String where = selection;
        if (uriMatcher.match(uri)== PERSONAS_ID){
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = personadbh.getWritableDatabase();

        cont = db.delete(TABLA_PERSONAS,where,selectionArgs);

        return cont;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int cont;

        String where = selection;
        if (uriMatcher.match(uri)== PERSONAS_ID){
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = personadbh.getWritableDatabase();

        cont = db.update(TABLA_PERSONAS,values,where,selectionArgs);

        return cont;
    }
}
