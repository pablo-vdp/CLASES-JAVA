/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.Clase9;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class mainOrg {
    public void main(String[] args) throws IOException {
//FICHERO SERIA CREAR
   
        File fhSeria = new File("vehiculo.obj"); //manejador 
    
        if(fhSeria.exists())//si existe se borra
            fhSeria.delete();
        
        addCabecera(fhSeria);
        
    //---PARTE MENU      
               do{
        menuInicial();
        
         Scanner entrada=new Scanner(System.in);
         
         System.out.println("Seleccione una opción");
         Integer opcion = entrada.nextInt();
        
        System.out.println("Opcion =>"+opcion);
        

        

        switch(opcion){
            case 1:
                System.out.println("-- Insercion de nuevo coche --");
                
                System.out.println("Inserte la matricula");
                String matricula = entrada.next();
                
                System.out.println("Inserte la marca");
                String marca = entrada.next();
                
                System.out.println("Inserte la capacidad");
                String capacidad = entrada.next();
                
                System.out.println("Inserte el modelo");
                String modelo = entrada.next();
                
                nuevoVehiculo(fhSeria,matricula,marca,Double.valueOf(capacidad),modelo);

                break;
            case 2:
                System.out.println("-- BORRADO --");
                
               System.out.println("Inserte la matricula");
               
               matricula = entrada.next();
                
                borrarVehiculo(fhSeria,matricula);
                break;
            case 3:
                System.out.println("Indique La matricula 3");
                break;
            case 4:
                System.out.println("Ver todos los coches");
                
                try {
                    FileInputStream fis = new FileInputStream(fhSeria);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                      
                    System.out.println("Antes try");
                    try {
                        while(true){
                           claseVehiculo9 vehiculo= (claseVehiculo9) ois.readObject();
                            System.out.println(vehiculo.toString());
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Final lectura de Serializable");
                    }

                    ois.close();
                    fis.close();
                
               // mostrarTodos(fhSeria);
                                } catch (FileNotFoundException ex) {
            Logger.getLogger(mainOrg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                    System.out.println( ex.getMessage() );
        }
                break;
            case 5:
                System.out.println("Ver datos coche");
                
                        
                        try {
            FileOutputStream fos = new FileOutputStream(fhSeria, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
             oos.writeObject(new claseVehiculo9("4842FLK", "Audi", 65.3, "A6-Avant"));
             
            oos.close();
            fos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(mainOrg.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;
            default:
                System.out.println("Entrada no esperada");
                break;
        }
       }while(true);//siempre muestra el menu O un "0" para salir 
//---FIN_MENU  
       
        
       

    }  
/*
    private static void mostrarTodos(File fhSeria) throws FileNotFoundException, IOException{
        try {
            FileInputStream fis = new FileInputStream(fhSeria);
            ObjectInputStream ois = new ObjectInputStream(fis);
                       
            claseVehiculo9 vehiculo;
            System.out.println("Antes try");
            try {
                System.out.println("DENTRO");
                while(true){
                    vehiculo = (claseVehiculo9) ois.readObject();
                    System.out.println(vehiculo);
                }
                //quitar exception into catch(*)
                
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Final lectura de Serializable");
            }

            ois.close();
            fis.close();
            
            
        } catch (IOException ex) {
        }
    }
   */

    private static void addCabecera(File fhSeria) {
        try {
            //generar nuevo fichero serializable
            fhSeria.createNewFile();
            //Cabecera > para que sepa leerlo
            
            FileOutputStream fos = new FileOutputStream(fhSeria,true);
            MiClaseOutput moo = new MiClaseOutput(fos);
            
            
            moo.close();
            fos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(mainOrg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private static void borrarVehiculo(File fhSeria,String matricula) {
      
            //fich auxiliar para almacenar todo
            File auxiliar = new File("auxiliar.obj");
        try {
            auxiliar.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(mainOrg.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {   //leer Serializable
                    FileInputStream fis = new FileInputStream(fhSeria);  
                ObjectInputStream ois = new ObjectInputStream(fis);
                //escribir Serializable
                FileOutputStream fos = new FileOutputStream(auxiliar);
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                //new Object de la clase
                claseVehiculo9 vehiculo;
                try {
                    while(true){
                        //leer obejeto (mediante el contructor de claseVehiculo9)
                        vehiculo = (claseVehiculo9) ois.readObject();
                        //test
                        System.out.println(vehiculo.toString());
                        
                        //mientras las matriculas no coincidan con la insertada
                        if(!vehiculo.getMatricula().equals(matricula))
                        oos.writeObject(vehiculo); //añade
                        
                    }
                } catch (Exception e) {
                    System.out.println("Final Fichero");
                }
                oos.close();
                fos.close();
                ois.close();
            
            fhSeria.delete(); //borrar fich origen;
            auxiliar.renameTo(fhSeria); //renombrar aux x nbOrigen
            
            } catch (IOException ex) {}

    }

    private static void nuevoVehiculo(File fhSeria,String matricula,String marca,Double capacidad,String modelo) {
        //1 Añadir Coche (fos/oos)
        addCabecera(fhSeria);
        try {
            FileOutputStream fos = new FileOutputStream(fhSeria);
            MiClaseOutput moo = new MiClaseOutput(fos);
                moo.writeObject(new claseVehiculo9(matricula,marca,capacidad,modelo));
            moo.close();
            fos.close();
            
            System.out.println("Vehiculo añadido con exito");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainOrg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            
        }
        
    }

    private static void menuInicial() { 
        System.out.println("SELECIONE UNA OPCION ");
        System.out.println("1- nuevo coche");
        System.out.println("2- dar de baja (x matricula)");
        System.out.println("3- mod datos vehiculo (x matricula)");
        System.out.println("4- Mostrar vehiculos");
        System.out.println("5- Ver Vehiculo");
       
    }
 
    
    
}
