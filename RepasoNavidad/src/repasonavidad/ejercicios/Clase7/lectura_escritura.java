/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.Clase7;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class lectura_escritura {
   static ArrayList<items> listaItems= new ArrayList<>();
    
    public void main(String[] args) throws FileNotFoundException, IOException {
        File fcBin = new File("productos.dat");
        
        File fcTxt = new File("datos.txt");
        
        try {
            fcBin.createNewFile();
            fcTxt.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(lectura_escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileInputStream fis = new FileInputStream(fcBin);
            DataInputStream dis = new DataInputStream(fis);
            
            int codigo;
            int cantidad;
            double precio;
            
            try {
                //SABADO
                //volcar ArrayList en binario y llamar a mostrarBinario (crear metodo para imprimir fich binario)
                while(true)
                {
                     codigo = dis.readInt();
                     cantidad = dis.readInt();
                     precio = dis.readDouble();
                     
                    listaItems.add(new items(codigo,cantidad,precio));
                
                    System.out.println(codigo+"/"+cantidad+"/"+precio);
                }
            } catch (Exception e) {
                System.out.println("FINAL DEL FICHERO");
            }
            
            dis.close();
            fis.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lectura_escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lectura_escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FileReader fr=new FileReader(fcTxt);
        BufferedReader br = new BufferedReader(fr);
        
        String linea= br.readLine();
        String modo[];
        
        
        while(linea != null)
        {
            modo =  linea.split(" ");
            
            if(modo[0].equals("Modificacion")){
                
                if(modo[2].equals("cantidad"))
                    listaItems.get(Integer.valueOf(modo[1])-1).setCantidad(Integer.valueOf(modo[3]));
                else{
                    listaItems.get(Integer.valueOf(modo[1])-1).setPrecio(Double.valueOf(modo[3]));
                }
            }else if(modo[0].equals("Alta")) {
                listaItems.add(new items(listaItems.size()+1,Integer.valueOf(modo[1]),Double.valueOf(modo[2])));
            }else if(modo[0].equals("Baja")) {
                int pos=Integer.valueOf(modo[1]);
                listaItems.remove(pos-1);
            }
              
            linea = br.readLine();
        }
        
        listaItems.forEach(c -> { System.out.println((c.toString()));});
    }
}
