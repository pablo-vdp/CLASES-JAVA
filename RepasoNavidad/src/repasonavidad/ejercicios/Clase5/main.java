/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.Clase5;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class main {
    private static ArrayList<Object> personajes = new ArrayList<>();
    
    static Asesino asesino;
    static Mago mago;
    static Guerrero guerrero;
    
    static double fuerzaP1;
    static double fuerzaP2;
     
    static double vidaP1;
    static double vidaP2;
    
    static String vida;
    
    public void main(String[] args) {
        personajes.add(new Asesino(10, "Alfraffa", "Orco", "H", 123, 2.12, 1000));
        
        personajes.add(new Guerrero(90, "Mamadu", "Ogro", "H", 50, 1.43, 800));
        
        personajes.add(new Mago(30, "WizHack", "Duende Magico", "H", 22, 1.76, 450));  
        
        System.out.println(luchar(0,1));
    }
       
    
    public static String luchar (int p1, int p2){
       String tipoP1 = personajes.get(p1).getClass().getName();
       String tipoP2 = personajes.get(p2).getClass().getName();
       String salida = "";
       
        switch (tipoP1) {
            case "repasonavidad.ejercicios.Clase5.Asesino":
                //pasa el T=objeto al T=asesino
                asesino = (Asesino) personajes.get(p1);
                salida +="P1 => Asesino Ataque = "+ asesino.ataque()+"/n";
                fuerzaP1 = asesino.ataque();
                
                vidaP1 = asesino.getVida();
                break;
                
            case "repasonavidad.ejercicios.Clase5.Mago":
                mago = (Mago) personajes.get(p1);
                salida += "P1 => Mago Ataque = "+mago.ataque()+"/n";
                fuerzaP1= mago.ataque();
                break;
            default:
                guerrero = (Guerrero) personajes.get(p1);
                salida += "P1 => Guerrero Ataque = "+guerrero.ataque()+"/n";
                fuerzaP1=guerrero.ataque();
                break;
        }
       
        switch (tipoP2) {
            case "repasonavidad.ejercicios.Clase5.Asesino":
                //pasa el T=objeto al T=asesino
                asesino = (Asesino) personajes.get(p2);
                salida +="P2 => Asesino Ataque = "+ asesino.ataque();
                fuerzaP2=asesino.ataque();
                break;
            case "repasonavidad.ejercicios.Clase5.Mago":
                mago = (Mago) personajes.get(p2);
                salida += "P2 => Mago Ataque = "+mago.ataque();
                fuerzaP2=mago.ataque();
                break;
            default:
                guerrero = (Guerrero) personajes.get(p2);
                fuerzaP2=guerrero.ataque();
                salida += "P2 => Guerrero Ataque = "+fuerzaP2;
                break;
        }
      
       // while (0 <= vidaP1 || vidaP2 == 0) {            
            asesino.setVida(vidaP1-fuerzaP2);
            
            salida = String.valueOf(asesino.getVida());           
       // }
        
        return salida;
    }
            
}
