/*
 
 1º.- Desarrollar una aplicación de control de llamadas realizadas en una centralita telefónica. 
 La centralita ira registrando el número de llamadas realizadas así como el coste total de 
 todas las llamadas realizadas. 

 Las llamadas tienen como atributos el número de origen, el número de destino y su duración 
 en segundos.

 Existen dos tipos de llamadas: 
 • Llamadas locales que cuestan 15 céntimos el segundo. 
 • Llamadas provinciales que dependiendo de la franja horaria en la que se realicen 

 -cuestan: 20 céntimos/sg en franja 1, 
           25 céntimos/sg en franja 2
           30 céntimos/sg en franja 3. 
 
 Finalmente, desarrollar la clase principal que cree una centralita, y registre las llamadas 
 de distinto tipo que vienen en el fichero de texto “llamadas.txt” y le pida a la centralita que 
 muestre por pantalla las llamadas según las vaya registrando, e informe del número 
 total de llamadas de cada tipo y la facturación total realizada
 */
package repasonavidad.EXAMEN1.centralita;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class main {
    public  void main(String[] args) {
        
        Provinciales prov;
        Locales loc;
        claseCentralita central;
        
        try {
            //leer
            File origen = new File ("C:\\Users\\Pablo\\Desktop\\Examen1\\llamadas.txt");
            
            FileReader fr = new FileReader(origen);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = br.readLine();
            
            central = new claseCentralita();
            
            while(linea!=null){
                String[] lineaSplt = linea.split(",");
                
                    int org = Integer.parseInt(lineaSplt[0]);
                    int destino = Integer.parseInt(lineaSplt[1]);
                    int tiempo = Integer.parseInt(lineaSplt[2]);
                                   
                if(lineaSplt[3].equals("0")){
                    loc = new Locales( org,destino,tiempo,0);
                    
                    int coste = loc.coste();
                    central.costeTotal(coste);
                    
                    central.totalLocales(1);
                    
                }else if(Integer.parseInt(lineaSplt[3])> 0){
                    int franja = Integer.parseInt(lineaSplt[3]);
                    prov = new Provinciales(org, destino, destino, franja);
                    
                    int coste = prov.coste();
                    central.costeTotal(coste);
                    
                    central.totalProvinciales(1);
                    
                }
                linea = br.readLine();
            }
            
            System.out.println(central.toString());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
