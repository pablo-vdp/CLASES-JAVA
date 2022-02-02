/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

/**
 *
 * @author Pablo
 */
public class clase1_array {

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
       //array vacio
        int [] numeros1 = new int [10];
       //array poblado
        int [] numeros2 = {0,1,2,3,4,5,6,7,8,9};
       //array poblado > string
       String numString = "0-1-2-3-4-5-6-7-8-9";
       String [] numeros3;
       numeros3 = numString.split("-");
       
       //rellenar array1 con bucle (x tamaño)
       for(int i=0 ; i<numeros1.length ; ++i){
           numeros1[i]=i;
       }
       
       // datos de num2 = num1 al reves 
       for(int i=numeros2.length; i > 0; --i){
           //tamaño de array - pos = a la pos del array1
           numeros2[numeros2.length-i] = numeros1[i-1];
       } 
       
       /*
       int i = -1;
       while(numeros2.length > ++i){ 
       }*/
       int i = 0;
       while(numeros2.length > i){
           System.out.println(numeros2[i]);
           i++;
       }
       
       }
    }
    
