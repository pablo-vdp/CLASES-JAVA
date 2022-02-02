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
public class Mago extends personaje {
   
    private int mana;
    
    public Mago(int mana, String nick, String raza, String sexo, int edad, double altura, double vida) {
        super(nick, raza, sexo, edad, altura, vida);
        this.mana=mana;
    }

    @Override
    public double ataque(){
        double vlrOrigen= super.ataque();
        return vlrOrigen*0.5 + 2*mana;
    }
}
