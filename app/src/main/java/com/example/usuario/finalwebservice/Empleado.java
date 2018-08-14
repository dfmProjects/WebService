package com.example.usuario.finalwebservice;

import android.graphics.drawable.Drawable;

public class Empleado {

    private String nombre;
    private String apellidos;
    private String estado;
    private Drawable imagen;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellidos, String estado, Drawable imagen) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}
