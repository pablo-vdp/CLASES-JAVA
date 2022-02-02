/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class mainSerializables {
    public void main(String[] args) {
        File f1 = new File("alumno.obj");
        
        if(f1.exists())
            f1.delete();
        
        try {
            f1.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(mainSerializables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //1ra vez usar ObjectOutput... == nueva cabecera
            
            FileOutputStream fos = new FileOutputStream(f1); // añade al fichero == tipo Alumno
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(new Clase8_Alumnos(1, "Pablo", "Illescas"));
            
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainSerializables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainSerializables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileOutputStream fos = new FileOutputStream(f1,true);
            MiClaseOutput moo = new MiClaseOutput(fos);// AL estar tipado no se vuelve a añadir
            
            moo.writeObject(new Clase8_Alumnos(2, "Pepe", "Palotes"));
            
            moo.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
            
        try {
           FileInputStream fis = new FileInputStream(f1);
           ObjectInputStream ois = new ObjectInputStream(fis);
           
           Clase8_Alumnos alumno; //declarar nuevo objeto alumno 
           
            try {
                while (true)
                {// guardar objeto como tipo alumno 
                    alumno = (Clase8_Alumnos) ois.readObject(); //guardar 
                    System.out.println(alumno.toString());
                }
            } catch (Exception ex) {
    
            }
           

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainSerializables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainSerializables.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
