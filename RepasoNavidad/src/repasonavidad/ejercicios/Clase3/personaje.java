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
public class personaje 
{
    //declarar variables
    
    String nick;
    String raza;
    String sexo;
    int edad;
    double altura;
    double vida;
   

// (constructor) => Rellamada a la clase


    public personaje(String nick,String raza, String sexo, int edad, double altura, double vida){
        this.nick = nick;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.vida = vida;
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

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    

    //Override => pisar funcion por defecto 
    public String info(){
        return  "Nick: '"+this.nick+
                "' Raza: '"+this.raza+
                "' Edad: '"+this.edad+
                "' Sexo: '"+this.sexo+
                "' Altura: '"+this.altura+"' \n";
    }
    
    public double ataque() {
      double randNum = (int)(Math.random()*(10)+1);
      return randNum;
    }
}
