/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.Clase5;

import repasonavidad.ejercicios.Clase3.personaje;

/**
 *
 * @author Pablo
 */
public class Asesino extends personaje{

    private int letalidad;

    public Asesino(int lealtad, String nick, String raza, String sexo, int edad, double altura, int vida) {
        super(nick, raza, sexo, edad, altura, vida); // => ref al constructor
        this.letalidad=letalidad;
    }
    
    @Override
    public double ataque(){
        //super. = this. => referencia al padre ()
        double vlrOrigen= super.ataque(); 
        return vlrOrigen*3 + letalidad*2;
    }
}
