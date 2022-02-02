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

/**
 *
 * @author Pablo
 */
public class claseLlamadas {
    private int numOrigen;
    private int numDestino;
    private int segundos;

    public claseLlamadas(int numOrigen, int numDestino, int segundos) {
        this.numOrigen = numOrigen;
        this.numDestino = numDestino;
        this.segundos = segundos;
    }

    public Integer getNumOrigen() {
        return numOrigen;
    }

    public void setNumOrigen(Integer numOrigen) {
        this.numOrigen = numOrigen;
    }

    public Integer getNumDestino() {
        return numDestino;
    }
    

    public void setNumDestino(Integer numDestino) {
        this.numDestino = numDestino;
    }

    public Integer getSegundos() {
        return segundos;
    }

    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return numOrigen + " " + numDestino + " " + segundos + " ";
    }
    
    
}
