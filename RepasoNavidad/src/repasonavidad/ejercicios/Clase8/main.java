/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.Clase8;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class main {
    public void main(String[] args) {
       File fcBin = new File("vehiculo.dat"); 
       File fcSeria = new File("vehiculo.obj");
       
       if(fcSeria.exists())
           fcSeria.delete();
       
        try {
            fcBin.createNewFile(); // Ficj Binario
            fcSeria.createNewFile(); //Fich Serialozable
            
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        try {
            FileOutputStream fos = new FileOutputStream(fcSeria, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
             oos.writeObject(new claseCoche("4842FLK", "Audi", 65.3, "A6-Avant"));
             
            oos.close();
            fos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        //Escribir en el Serializable
        try {
            FileOutputStream fos = new FileOutputStream(fcSeria,true);
            MiClaseOutput moo = new MiClaseOutput(fos);
            // ALT+MAYUS+M >> transformar a metodo
            LeerBin_EscribirSerializable(fcBin, moo, fos);
            LeerSerializable(fcSeria);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modFichSerializable(fcSeria);
        
        try {
            LeerSerializable(fcSeria);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void modFichSerializable(File fcSeria) {
        try {
            //mod serializables    
            File auxiliar = new File("auxiliar.obj");
            auxiliar.createNewFile();
            
            FileInputStream fis = new FileInputStream(fcSeria);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            FileOutputStream fos = new FileOutputStream(auxiliar);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            claseCoche vehiculo; //declarar var del objeto
            
            try {
                while (true) {                
                    vehiculo = (claseCoche) ois.readObject();
                    if(!vehiculo.getMatricula().equals("a1"))
                        oos.writeObject(vehiculo);
                }
            } catch (Exception e) {
            }
            
            oos.close();
            fos.close();
            
            ois.close();
            fis.close();
            
            fcSeria.delete();
            auxiliar.renameTo(fcSeria);
        
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void LeerSerializable(File fcSeria) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(fcSeria);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        claseCoche vehiculo;
        
        // bin + ser while(true)
        try {
            while(true){
                vehiculo = (claseCoche) ois.readObject();
                System.out.println(vehiculo.toString());
            }
            //quitar exception into catch(*)
            
        } catch (Exception ex) {
            System.out.println("Final lectura de Serializable");
        }      
        ois.close();
        fis.close();
    }

    private static void LeerBin_EscribirSerializable(File fcBin, MiClaseOutput moo, FileOutputStream fos) {
        // LEER FICH BINARIO
        try {
            FileInputStream fis = new FileInputStream(fcBin);
            DataInputStream dis = new DataInputStream(fis);
            
            String marca;
            String modelo;
            double capacidad;
            String matricula;
            
            //Acceder a cada valor de la linea (Registro)
            try {
                
                while(true){
                    marca = dis.readUTF();
                    modelo = dis.readUTF();
                    capacidad = dis.readDouble();
                    matricula = dis.readUTF();
                    
                    System.out.println("Marca: "+marca+" Modelo: "+modelo);
                    //Nueva linea como objeto > usando el constructor de la clase vehiculo
                    moo.writeObject(new claseCoche(matricula, marca, capacidad, modelo));
                    
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            
            moo.close();
            fos.close();
            
            dis.close();
            fis.close();
            
        } catch (IOException ex) {
            System.out.println("FINAL DEL FICHERO");
        }
    }
}

