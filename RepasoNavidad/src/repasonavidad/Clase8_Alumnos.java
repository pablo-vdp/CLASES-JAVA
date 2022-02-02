/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class Clase8_Alumnos implements Serializable{
    private int id;
    private String nombre;
    private String apellido;

    public Clase8_Alumnos(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Clase8_Alumnos{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}
