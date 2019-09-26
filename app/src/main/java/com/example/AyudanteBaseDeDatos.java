package com.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AyudanteBaseDeDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BASE_DATOS = "cuentas",
                            NOMBRE_TABLA = "usuarios";
    private static final int VERSION_BASE_DE_DATOS = 1;

    public AyudanteBaseDeDatos(Context context) {
        super(context, NOMBRE_BASE_DATOS,null,VERSION_BASE_DE_DATOS);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREAR LA TABLA:
        sqLiteDatabase.execSQL(String.format(
                "CREATE TABLE IF NOT EXISTS %s(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, edad INTEGER, correo TEXT," +
                        "usuario TEXT,contraseña TEXT)",NOMBRE_TABLA));

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
