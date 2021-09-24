/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

/**
 *
 * @author Pablo
 */
public class JavaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ArrayMeses[][] = new int [12][];
        
        for(int i = 0;ArrayMeses.length < i ;i++){
            if (i==1){
                ArrayMeses[1]=new int [28]; //reservar espacios en el 1er Array (2da POS)
            }else if (i%2==0){
                ArrayMeses[i]=new int [31]; // meses pares = 31 dias
            }else{
                ArrayMeses[i]=new int [30]; //meses impares = 30 
            }
        }
        
       //relelnar Arrays
       
       for (int i = 0;ArrayMeses.length < i ;i++){          //recorrer cada array
           for (int j = 0;ArrayMeses[i].length < j ;j++){   //dentro de cada array recorrer cada pos
               ArrayMeses[i][j]=j+1;                        //añadir num a cada espacio/pos reservado
               System.out.println(ArrayMeses[i][j]);
               System.out.println("HOLITA");
           }  System.out.println("HOLA"+i);  
        }System.out.println("HOLI");
    }
}
