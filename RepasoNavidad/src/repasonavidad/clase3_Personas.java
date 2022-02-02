/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

/**
 *
 * @author Pablo
 */
public class clase3_Personas 
{
    private String dni;
    private String nombre;
    private int edad;
    private double sueldo;

    //ALT + INSERT >> contructor
    public clase3_Personas(String dni, String nombre, int edad, double sueldo)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

//METODOS GETTERS & SETTER
    // devuelve DNI
    public String getDni() {
        return this.dni;
    }
    // Selecciona y modifica 
    public void setDni(String dni)
    {
        //DNI del objeto = dni
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    @Override
    public String toString() {
        return "Hola mi nombre es "+ this.nombre +" con DNI " + this.dni + " edad = "+this.edad ;
    }
    
    public double sueldoAnual(){
    
       if(this.edad > 20)
           return 12 * this.sueldo;
       else
          return 14 * this.sueldo;
    }
}
