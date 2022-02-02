/*
Ejercicio 2. Longitudes de cada una de las dimensiones de un array
Cree una clase y su correspondiente método main. Defina un array bidimensional de 3 x 4 de tipo
String e inicialó. Imprima por pantalla sus dimensiones utilizando length. del primero. 
 */
package repasonavidad.ejercicios.Clase2;

public class ej2 {
    public void main(String[] args) {
        String [][] lista = new String[3][4];
         boolean valido = false;
        
        for (int i = 0; i< lista.length && !valido ; ++i){
            if(i == 0){
                System.out.println("La longitud de la 1ra dimension es "+lista[i].length);
                valido = true;
            }
        }
        
    }
}
