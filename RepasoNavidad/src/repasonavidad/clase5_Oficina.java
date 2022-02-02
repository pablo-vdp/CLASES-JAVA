/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class clase5_Oficina {
//lista de objetos > usando contructor heredado + new Variables
    private static ArrayList<Object> oficina = new ArrayList<>();
    
    static clase5_empleado empleado;
    static  clase5_Jefe jefe;
    
    public void main(String[] args) {
        //distintos tipos en el mismo arrayList
        oficina.add(new clase5_empleado(1, "AAA", "junior", 18, 2000));
        oficina.add(new clase5_empleado(2, "BBB", "senior", 23, 2000));
        oficina.add(new clase5_empleado(3, "CCC", "becario", 21, 2000));
        
        oficina.add(new clase5_Jefe("correo", "dnBOS", "DDD", 40, 3000));
        
        for(int i = 0; i<oficina.size(); ++i){
            //si el registro viene de la claseEmpleado
            String nbClase = oficina.get(i).getClass().getName();
            if(nbClase.equals("repasonavidad.clase5_empleado"))
            {
            //decirle al programa el "tipo" de la persona (classEmpleado/Jefe)
            //pasar de tipo Objeto a tipo Empleado
                empleado = (clase5_empleado) oficina.get(i);
                System.out.println(empleado.sueldoAnual());
            }else{
               jefe =(clase5_Jefe) oficina.get(i);
                System.out.println(jefe.sueldoAnual());
            }
        }
        
        jefe =(clase5_Jefe) oficina.get(3);
        System.out.println(jefe.getEmail());
        
        empleado = (clase5_empleado) oficina.get(1);
        System.out.println(empleado.getNum_telefono());
        
        empleado = (clase5_empleado) oficina.get(2);
        System.out.println(empleado.getSueldo());
        
        jefe = (clase5_Jefe) oficina.get(3);
        System.out.println(jefe.getDni());
    }
}
