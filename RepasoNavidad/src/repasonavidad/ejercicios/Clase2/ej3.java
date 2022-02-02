/*
Ejercicio 3. Crea un arrayList, y añade 20 registros numéricos  del 1 - 3

(mirate el método random). 
Quiero que imprimas hasta que encuentre el número 3. Cuando encuentra el número,
devuelve la posición donde está,
la cambias por otro número y vuelve a imprimir todo el array. 
 */
package repasonavidad.ejercicios.Clase2;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class ej3 {
    public void main(String[] args) {
        
    ArrayList<Integer> listaNums = new ArrayList<>();
    //RELLLENAR ARRAY 20 POS
        for (int i = 0;i<20;++i){
            int randNum = (int)(Math.random()*(3)+1);
            listaNums.add(randNum);   
            System.out.println("pos "+(i+1)+" => "+listaNums.get(i));
        }
        System.out.println("------------ GUARDAR POSICIONES VALOR = 3----------");
        
   //BUSCAR VALOR "3" > POS + CAMBIAR VALOR 

    ArrayList<Integer> listaPos = new ArrayList<>();

        for(int i = 0;i<listaNums.size();++i){         
            if(listaNums.get(i)==3){
                listaPos.add(i);
                System.out.println("Num 3 en la pos "+(i+1));
            }
        }
       
    //MOD VALOR de POS con VALOR = 3
    
        for (int i = 0; i<listaPos.size();++i){
            //int randNum2 = (int)(Math.random()*(9-4)+1);
            int pos=listaPos.get(i);
   
            listaNums.set(pos,404);
        }
        System.out.println("----------- LISTA MOD 3 x 404 --------------");
        
    //MOSTRAR LISTA MODIFICADA
        for (int i = 0; i<listaNums.size();++i){
            System.out.println(listaNums.get(i));
        }
        
    }
}
