/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.EXAMEN2.ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Pablo
 */
public class main {
    public static void main(String[] args) throws IOException {
        
        OperacionesAnimales op = new OperacionesAnimales();
        
       /* op.addGato(new claseGato("Siberiano", "Mark", 2));
        op.addGato(new claseGato("Bengala", "Piston", 4));
        op.addGato(new claseGato("Siames", "Firulais", 1));
        op.addGato(new claseGato("Persa", "Sugus", 5));
        op.addGato(new claseGato("Egipcio", "Micky", 3));
                
        op.addPerro(new clasePerro("Marron", "Perla", 2));
        op.addPerro(new clasePerro("Canela", "Kimbo", 8));
        op.addPerro(new clasePerro("Negro", "Miel", 4));
        op.addPerro(new clasePerro("Manchas", "Yanko", 8));
        op.addPerro(new clasePerro("Gris", "Jack", 9));*/
       
        File origen = new File("C:\\Users\\Pablo\\Desktop\\Examen 2-20220115\\animales.txt");
        
        FileReader fr = new FileReader(origen);
        BufferedReader br = new BufferedReader(fr);
        
        String lnAnimal = br.readLine();
        
        
        while(lnAnimal != null){
            String[] linea = lnAnimal.split(" ");
            if(linea[0].equalsIgnoreCase("P")){
                 op.addPerro(new clasePerro(linea[1], Integer.parseInt(linea[2]), linea[3]));
            }else{
                op.addGato(new claseGato(linea[1], Integer.parseInt(linea[2]),linea[3] ));
            }
            lnAnimal = br.readLine();
        }
        
        op.guardarAnimales("Animales.dat");
        
        op.leerAnimales("Animales.dat");
        
        
    }
}
