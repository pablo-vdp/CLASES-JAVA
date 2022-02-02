/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

public class clase2_arrayMulti {
    public void main(String[] args) {
        int [][] arrayMulti = new int[4][3];
        
        for(int i = 0;i<arrayMulti.length;++i){
            for( int j=0;j<arrayMulti[i].length;++j){
                arrayMulti[i][j]=j;
            }
        }
        arrayMulti[3][2]=8;
        //recorrer Array multi
        for(int i = 0;i<arrayMulti.length;++i){
            for( int j=0;j<arrayMulti[i].length;++j){
                System.out.print(arrayMulti[i][j]);
            }
            System.out.println("");
        }
        
        arrayMulti[2][1]=5;
        //recorrer bucle hasta ver un 5 => indicar pos [3][2]
        boolean encontrado = false;
        // mientras(i<tmñArrray Y !FalseBooleano)
        for(int i = 0;i<arrayMulti.length && !encontrado ;++i){
            for( int j=0;j<arrayMulti[i].length && !encontrado ;++j){
                if(arrayMulti[i][j] == 5){
                    System.out.println("Se encuntra en la posicion"+(i+1)+"-"+(j+1));
                    encontrado = true;
                }
            }
        }
        
    }
}
