/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class clase6_lectura_ficheros_texto 
{
    public  void main(String[] args) 
    {
   //tipo File nbVar = new File("nb_fich")
     File fichTxt = new File("prueba.txt"); //crear la variable del fichero
   //si existe te lo cargas
     if(fichTxt.exists())
        fichTxt.delete();
       //try-catch == crear fich ALT+ENTER
     try {
        fichTxt.createNewFile();
     } catch (IOException ex) {
        Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
     }
      
        try {
            FileWriter fw = new FileWriter(fichTxt, true);// FileWriter(var, TRUE) == añade
            fw.write("hola mundo"+"\n"); //linea nueva
            fw.write("adios mundo");
            fw.close();             //cerrar fichero
        } catch (IOException ex) {
            Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileReader fr = new FileReader(fichTxt); // Leer fichero
            BufferedReader br = new BufferedReader(fr); //Buffer => linea a linea 
            
            String linea = br.readLine(); // guardar linea en la var > ALT + ENTER (clausula)
            //con el WHILE mostramos cada línea del fichero hastas FEOF
            while(linea != null)
            {
                System.out.println(linea);
                linea = br.readLine();
            }
            
            fr.close();
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clase6_lectura_ficheros_texto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
