/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.EXAMEN1.centralita;


/**
 *
 * @author Pablo
 */
public class claseCentralita {
    private int locales;
    private int provinciales;
    private int costeTotal;
    

    public claseCentralita() {
        this.locales = 0;
        this.provinciales = 0 ;
        this.costeTotal = 0;
    }

    public int costeTotal (int precio){
         costeTotal  += precio; 
        return costeTotal;
    }
    
    public int totalLocales (int nLocal){
        locales += nLocal;
        return locales;
    }
    
        public int totalProvinciales (int nProv){
        provinciales += nProv;
        return provinciales;
    }

   @Override
    public String toString() {
        return "LLAMADAS LOCALES => "+ totalLocales(locales)+"\n"  
                +"LLAMADAS PROVINCIALES => "+ totalProvinciales(provinciales)+"\n"
                +"COSTE TOTAL => "+costeTotal(costeTotal);
    }
    
    

}
