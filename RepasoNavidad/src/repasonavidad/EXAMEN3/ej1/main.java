/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.EXAMEN3.ej1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class main {
    public static void main(String[] args) {
        //leer binario
  
        
        try {
            FileInputStream fis = new FileInputStream("productos.dat");
            DataInputStream dis = new DataInputStream(fis);
            
            File auxiliar = new File("auxiliar.dat");
            
            FileOutputStream fos = new FileOutputStream(auxiliar);
            DataOutputStream dos = new DataOutputStream(fos);
   
            
            try {
                 
                System.out.println("PRODUCTOS");
                while (true) {    
                    
                    int referencia = dis.readInt();
                    double precio = dis.readDouble();
                    

                    if(precio > 300){
                        
                        dos.writeInt(referencia);
                        dos.writeDouble(precio -(precio*0.15));
                        
                    }else if (precio >= 100 && precio <= 300){
                        
                        dos.writeInt(referencia);
                        dos.writeDouble(precio -(precio*0.05));
                        
                    }else if(precio < 50){
                        
                    }else{
                        dos.writeInt(referencia);
                        dos.writeDouble(precio);
                    }
                        
                    System.out.println("Referencias "+referencia+ " Precios "+ precio);
                }
            } catch (IOException e) {
                System.out.println("FINAL DE LECTURA");   
            }
            
            dos.close();
            fos.close();
            
            dis.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //leer auxi 
        
                 
        try {
            FileInputStream fis = new FileInputStream("auxiliar.dat");
            DataInputStream dis = new DataInputStream(fis);
            
            
            try {
                while(true){
                     int referencia = dis.readInt();
                    double precio = dis.readDouble();
                    
                    System.out.println("AUX > "+ referencia+" precio = " + precio);
                }
            } catch (Exception e) {
            }
 
            
            dis.close();
            fis.close();
            
        } catch (FileNotFoundException ex) {
           
        } catch (IOException ex) {
            
        }
           
                   
        try {
           FileInputStream  fis = new FileInputStream("ventas.dat");
           DataInputStream dis = new DataInputStream(fis);
            
           File salida = new File ("salida.txt");
           FileWriter fw = new FileWriter(salida);
           
           BufferedWriter bw = new BufferedWriter(fw);
            
            try {
                while (true) {                
                    String nombreVendedor = dis.readUTF();
                    String CodProd = String.valueOf(dis.readInt());
                    String Unidas = String.valueOf(dis.readInt());
                
                    bw.write("El vendedor" +nombreVendedor+ " ha vendido " +Unidas+" unidades del producto " +CodProd+ " lo que equivale a euros");
                    bw.newLine();
                }
            } catch (Exception e) {
            }
            
            bw.close();
            fw.close();
            dis.close();
            fis.close();
               
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}

