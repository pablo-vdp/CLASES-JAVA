/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.Clase4;

import java.util.ArrayList;
import repasonavidad.clase3_Personas;
import repasonavidad.ejercicios.Clase3.personaje;

/**
 *
 * @author Pablo
 */
public class main {
//declarar ArrayList como "constructor" > lista de objetos
    private static ArrayList<personaje> personajes = new ArrayList<>();
    
    public void main(String[] args) {
    //dar de alta personajes en lista de objetos
        newPersonaje("Rakkaton", "Orco", "H", 122, 2.61,100);
        newPersonaje("Gayar", "Enano", "H", 80, 1.35,100);
        newPersonaje("Dakrax", "Gnomo", "M", 47, 1.72,100);
        newPersonaje("Ailiten", "Trol", "M", 32, 1.85,100);
    
    //ver datos de los personajes  
    
        for(int i = 0;i<personajes.size();++i){
            System.out.println((i+1)+"- "+personajes.get(i).info());
        }
        
    
    //comparar edad de 2 personajes
        System.out.println(comparaEdad(2, 0));
    }
// metodo para generar un personaje    
    private static void newPersonaje(String nick, String raza, String sexo ,int edad , double altura, double vida){
        //añadir personaje a la lista mediante el constructor
        personajes.add(new personaje(nick, raza, sexo, edad, altura,vida));
    }
    
//metodo comparar edad 1,2 (V2 > pasar num personaje)
    private static String comparaEdad(int p1, int p2){
       int edad_1 = personajes.get(p1).getEdad();
       int edad_2 = personajes.get(p2).getEdad();
       
       String salida = new String();
       
       if(edad_1 > edad_2)
           salida = "El personaje "+personajes.get(p1).getNink()+"("+edad_1+") es mayor que "+personajes.get(p2).getNink()+"("+edad_2+")";
       else{
           salida = "El personaje "+personajes.get(p2).getNink()+"("+edad_2+") es mayor que "+personajes.get(p1).getNink()+"("+edad_1+")";
       }
       return salida;
    }
}
