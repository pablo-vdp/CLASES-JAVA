/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.util.ArrayList;
import repasonavidad.ejercicios.Clase3.personaje;

/**
 *
 * @author Pablo
 */
public class clase4_Objetos {
    //crear arrayList GLOBAL
    //Nuevo arrayList del Objeto Persona (constructor)
    private static  ArrayList <clase3_Personas> oficina = new ArrayList<>(); //Oficina vacia
    
    public void main(String[] args) 
    {
        anadirPersona("232","Joao", 34);
        anadirPersona("001", "Pepe", 19);
        
        System.out.println(verDni());
        
        //oficina.get(1).setEdad(23);
        
        //System.out.println(oficina.get(1).toString());
    }
    
    private static void anadirPersona(String dni, String nombre, int edad)
    {/*
        clase3_Personas persona = new clase3_Personas(dni,nombre,edad);//crear la persona
        oficina.add(persona);// añadir a la lista de objetos
        //oficina.add(new clase3_Personas(dni,nombre,edad));*/
    }
    
    private static String verDni()
    {
       String salida = "Los DNIs de la BBDD son: ";
       
       for(int i = 0; i < oficina.size(); ++i)
       {
            if(i==oficina.size()-1){
                salida += oficina.get(i).getDni()+".";
            }else{
                salida += oficina.get(i).getDni()+",";
            }
       }
       
       return salida;
    }

}
