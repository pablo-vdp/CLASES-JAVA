/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.EXAMEN1.centralita;

/**
 *
 * @author Pablo
 */ 
public class Locales extends claseLlamadas{

    public Locales(int numOrigen, int numDestino, int segundos, int franja) {
        super(numOrigen, numDestino, segundos);
        this.franja = franja;
    }
    private int franja;     

    public int getFranja() {
        return franja;
    }

    public void setFranja(int franja) {
        this.franja = franja;
    }

    @Override
    public String toString() {
        return super.toString()+ franja;
    }
    
    public Integer coste() {
        return this.getSegundos()*15;
    }
    
    
}
