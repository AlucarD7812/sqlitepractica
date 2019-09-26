package com.example.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.AyudanteBaseDeDatos;
import com.example.modelos.Usuarios;

public class UsuariosController {
    private AyudanteBaseDeDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "usuarios";

    public UsuariosController(Context context) {
        ayudanteBaseDeDatos = new AyudanteBaseDeDatos(context);
    }
    public long nuevoUsuario(Usuarios usuario){
        //Para escribir en la bd write
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresAInsertar = new ContentValues();
        valoresAInsertar.put("nombre",usuario.getNombre());
        valoresAInsertar.put("edad",usuario.getEdad());
        valoresAInsertar.put("correo",usuario.getCorreo());
        valoresAInsertar.put("usuario",usuario.getUsuario());
        valoresAInsertar.put("contraseña",usuario.getContraseña());
        return baseDeDatos.insert(NOMBRE_TABLA,null,valoresAInsertar);
    }
}
