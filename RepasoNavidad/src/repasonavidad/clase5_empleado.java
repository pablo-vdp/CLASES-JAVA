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
// heredar metodos de la clase => extends nb_clase
public class clase5_empleado extends clase3_Personas{
   
   private int num_telefono;
   
//constructor del empleado (sus variables + variables del padre)
    public clase5_empleado(int num_telefono, String dni, String nombre, int edad, double sueldo) {
        
        super(dni, nombre, edad, sueldo); //=> llamada a constructor padre >> añadir vaiables del padre 
        this.num_telefono = num_telefono;
        
    }

    public int getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(int num_telefono) {
        this.num_telefono = num_telefono;
    }

    @Override
    public String toString() {
        
        String toStrng = super.toString(); //llamar al metodo toStrind del padre
        return toStrng+"clase5_empleado{" + "num_telefono=" + num_telefono + '}';
    }
    
//Sobreescribir metodo padre para usarlo en el hijo
    @Override
    public double sueldoAnual(){
        return super.sueldoAnual() + 2000;
    }


}
