/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.util.ArrayList;

public class clase2_arrayList {
    public void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>();
        
        numeros.add(13);
        numeros.add(0,23);
        numeros.add(1,54);
        
        System.out.println("Tamaño array = "+numeros.size());
        
        for(int i = 0; i< numeros.size();++i){
            System.out.println("valor en la Pos "+i+" => "+numeros.get(i));
        }
        
        numeros.add(29);
        numeros.add(4);
        numeros.add(12);
        
        boolean valido = false;
 
        for (int i= 0;i<numeros.size() && !valido ;++i){
            System.out.print(numeros.get(i)+"-");
            if(numeros.get(i)==4){
                valido = true;
            }
        }
    }
    
    private static void imprimirBucle(ArrayList lista){
        for (int i= 0;i<lista.size();++i){
            System.out.print(lista.get(i));
        }
    }
}
