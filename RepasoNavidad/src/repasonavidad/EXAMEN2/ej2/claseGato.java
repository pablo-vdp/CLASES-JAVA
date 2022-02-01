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
public class claseGato extends claseAnimales implements NewInterface{
    
    private String raza;
    
    public claseGato(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
        
        
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

   
    public String toString() {
       return "G "+super.toString()+" "+raza;
    }

    @Override
    public void tipo() {
        System.out.println("GATO");
    }

    @Override
    public void sonido() {
        System.out.println("MIAU");
    }
    
    
}
