package com.example.usuario.finalwebservice;

import android.graphics.drawable.Drawable;

public class Empleado {

    private String nombre;
    private String apellidos;
    private String id;
    private Drawable imagen;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellidos, String id, Drawable imagen) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}
