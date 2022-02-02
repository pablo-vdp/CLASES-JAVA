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

//heredar metodos del padre Personas + añadir email
public class clase5_Jefe extends clase3_Personas{
    private String email;

    public clase5_Jefe(String email, String dni, String nombre, int edad, double sueldo) {
        super(dni, nombre, edad, sueldo);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public double sueldoAnual() {
        return super.sueldoAnual();
    }
    
}
