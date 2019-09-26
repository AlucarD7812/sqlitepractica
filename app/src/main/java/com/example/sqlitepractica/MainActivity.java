package com.example.sqlitepractica;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AyudanteBaseDeDatos;
import com.example.controllers.UsuariosController;
import com.example.modelos.Usuarios;

public class MainActivity extends AppCompatActivity {

    EditText etNombre,etEdad,etCorreo,etUsuario,etContraseña,etUser,etpassword;
    TextView tvmensaje;

    UsuariosController usuarioscontroller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        etCorreo = findViewById(R.id.etCorreo);
        etUsuario = findViewById(R.id.etUsuario);
        etContraseña = findViewById(R.id.etContraseña);
        etUser=findViewById(R.id.etuseringre);
        etpassword=findViewById(R.id.etpassingre);

        tvmensaje=findViewById(R.id.textingreso);

        usuarioscontroller=new UsuariosController(MainActivity.this);
    }

    public void btn_crear(View view)
    {
        try {
            String nombre = etNombre.getText().toString();
            String edadst=etEdad.getText().toString();
            String correo = etCorreo.getText().toString();
            String usuario = etUsuario.getText().toString();
            String contraseña=etContraseña.getText().toString();
            //validar que no queden vacios:
            if ("".equals(nombre)){
                etNombre.setError("debes ingresar el nombre");
                etNombre.requestFocus();
                return;
            }
            if ("".equals(edadst)){
                etEdad.setError("debes ingresar tu edad");
                etEdad.requestFocus();
                return;
            }
            if ("".equals(correo)){
                etCorreo.setError("debes ingresar su correo");
                etCorreo.requestFocus();
                return;
            }
            if ("".equals(usuario)){
                etUsuario.setError("debes ingresar su usuario");
                etUsuario.requestFocus();
                return;
            }
            if ("".equals(contraseña)){
                etContraseña.setError("debes ingresar su contraseña");
                etContraseña.requestFocus();
                return;
            }
            int edad = Integer.parseInt(etEdad.getText().toString());

            Usuarios usuarios = new Usuarios(nombre,edad,correo,usuario,contraseña);
            long creado = usuarioscontroller.nuevoUsuario(usuarios);
            if (creado == -1){
                //error
                Toast.makeText(MainActivity.this,"error al insertar",Toast.LENGTH_LONG).show();
            }
            else{
                //correcto
                Toast.makeText(MainActivity.this,"se inserto el usuario correctamente",Toast.LENGTH_LONG).show();

            }
        }
        catch (Exception ex)
        {
            Toast.makeText(MainActivity.this,ex.getMessage().toString(),Toast.LENGTH_LONG).show();
        }

    }

    public void btn_ingresar(View view)
    {
        try {
            AyudanteBaseDeDatos abd=new AyudanteBaseDeDatos(MainActivity.this);
            SQLiteDatabase bd=abd.getReadableDatabase();

            String comando="select usuario,contraseña from usuarios";
            Cursor c=bd.rawQuery(comando,null);
            if(c.moveToFirst())
            {
                do {
                    String user=c.getString(0);
                    String pass=c.getString(1);
                    if(user.equals(etUser.getText().toString()) && pass.equals(etpassword.getText().toString()))
                    {
                        tvmensaje.setText("Acceso concedido");
                    }
                    else
                    {
                        tvmensaje.setText("Acceso denegado");
                    }

                }
                while (c.moveToNext());
            }

        }
        catch (Exception ex)
        {

        }




    }
}
