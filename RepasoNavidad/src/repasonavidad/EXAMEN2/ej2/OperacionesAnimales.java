/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.EXAMEN2.ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.events.FileReadEvent;
import repasonavidad.MiClaseOutput;

/**
 *
 * @author Pablo
 */
public class OperacionesAnimales {
    //ArrayList Obejetos
    ArrayList<claseAnimales> Animales = new ArrayList<claseAnimales>();
    
    //addPerro
   public void addPerro(clasePerro perro){
       Animales.add(perro);
   }
   
       //addGato
   public void addGato(claseGato gato){
       Animales.add(gato);
   }
   
    public void guardarAnimales(String nombrefichero) throws FileNotFoundException {
        File fichAnimales = new File(nombrefichero);
        
        if(fichAnimales.exists())
            fichAnimales.delete();
        
        try {
            fichAnimales.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(OperacionesAnimales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            FileOutputStream fos = new FileOutputStream(fichAnimales,true);
        try {
            
            ObjectOutputStream oos;
         
           for(int i = 0; i < Animales.size(); ++i){
                if(fichAnimales.length()==0){
                    oos = new ObjectOutputStream(fos);
                }else{
                    oos = new repasonavidad.EXAMEN2.ej2.MiClaseOutput(fos) ;
                }
                
                oos.writeObject(Animales.get(i));
           }
           

           fos.close();
           
        } catch (IOException ex) {
            System.out.println(ex);
        }     
    }
    
    public void leerAnimales(String nombrefichero) throws FileNotFoundException, IOException{
        
        FileInputStream fis = new FileInputStream(nombrefichero);
        ObjectInputStream ois = new ObjectInputStream(fis);
       
        try {
            while (true){
            claseAnimales animales = (claseAnimales) ois.readObject();
            System.out.println(animales.toString());
        }
        } catch (Exception e) {
            System.out.println("FINAL DEL FICHERO");
        }
        
        ois.close();
        fis.close();
          
    }
}
