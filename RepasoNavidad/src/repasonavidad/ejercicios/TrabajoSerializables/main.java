/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.TrabajoSerializables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class main {
    public void main(String[] args) {
        //crear fichero 
        File motos = new File ("Motos.obj");
        
        if(motos.exists())
            motos.delete();
        
        try {
            motos.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //claseMoto moto= new claseMoto(");
        
        //escribir (cabecara)

           try {
                FileOutputStream fos = new FileOutputStream(motos);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                oos.writeObject( new claseMoto("true", "true",0));

                oos.close();
                fos.close();
                
        } catch (Exception e) {
        }
           
         //escribir (usando la cabecara)       
        try {
            FileOutputStream fos = new FileOutputStream(motos,true);
            //no hace falta usarla
            MiClaseOutput moo = new MiClaseOutput(fos);// AL estar tipado no se vuelve a añadir
            
            moo.writeObject(new claseMoto("BMW", "R_1500", 1500));
            
            moo.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
        //leer
          try {
           FileInputStream fis = new FileInputStream(motos);
           ObjectInputStream ois = new ObjectInputStream(fis);
           
            
           
            try {
                while (true)
                {// guardar objeto como tipo alumno 
                   claseMoto moto = (claseMoto) ois.readObject(); //casteo Clase >> para q sepa de donde viene 
                    System.out.println(moto.toString());
                }
            } catch (Exception ex) {
    
            }
           

        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
