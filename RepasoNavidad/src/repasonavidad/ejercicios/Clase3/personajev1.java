/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.Clase3;

/**
 *
 * @author Pablo
 */
public class personajev1 
{
    //declarar variables
    
    String nick;
    String raza;
    String sexo;
    int edad;
    double altura;

// (constructor) => Rellamada a la clase
    public personajev1(String nick,String raza, String sexo, int edad, double altura){
        this.nick = nick;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;     
    }
    
    public String getNink() {
        return this.nick;
    }

    public void setNink(String nink) {
        this.nick = nink;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //Override => pisar funcion por defecto 
    public String info(){
        return  "Nick: '"+this.nick+
                "' Raza: '"+this.raza+
                "' Edad: '"+this.edad+
                "' Sexo: '"+this.sexo+
                "' Altura: '"+this.altura+"' \n";
    }    
}
