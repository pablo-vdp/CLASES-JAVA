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
public class Provinciales extends claseLlamadas{
    private int franja;

    public Provinciales(Integer numOrigen, Integer numDestino, Integer segundos , int franja) {
        super(numOrigen, numDestino, segundos);
        this.franja = franja;
    }
    
    public int coste(){
        int coste = 0;
        if(franja == 1){
            coste =  this.getSegundos()*20;
        }else if(franja == 2){
            coste = super.getSegundos()*25;
        }else{
            coste = super.getSegundos()*30;
        }
        return coste;
    }
}
