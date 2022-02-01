/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.EXAMEN2.ej2;

/**
 *
 * @author Pablo
 */
public class clasePerro extends claseAnimales implements NewInterface{
    private String color;

    public clasePerro(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
       return "P "+super.toString()+" "+color;
    }

    @Override
    public void tipo() {
        System.out.println("PERRO");
    }

    @Override
    public void sonido() {
        System.out.println("GUAU");
    }
   
}
