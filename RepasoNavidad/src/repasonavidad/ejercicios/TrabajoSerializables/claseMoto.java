/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.TrabajoSerializables;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class claseMoto implements Serializable{
    private String marca;
    private String modelo;
    private int cc;

    public claseMoto(String marca, String modelo, int cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.cc = cc;
    }

    public String getMarca() {
        return marca;
    }
    
    public void setDefault (){
       new claseMoto("X", "Y", 0);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "claseMoto{" + "marca=" + marca + ", modelo=" + modelo + ", cc=" + cc + '}';
    }   
}
