package com.example.modelos;

public class Usuarios {
    private String nombre;
    private int edad;
    private String correo;
    private String usuario;
    private String contraseña;
    private int id;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Usuarios() {
    }
    public Usuarios(String nombre,int edad, String correo,String usuario,String contraseña) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.usuario=usuario;
        this.contraseña=contraseña;
    }
    public Usuarios(String nombre,int edad, String correo,String usuario,String contraseña, int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.id = id;
    }
}
