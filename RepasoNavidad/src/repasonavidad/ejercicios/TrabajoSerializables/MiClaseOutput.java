/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.TrabajoSerializables;

import java.io.*;
public class MiClaseOutput extends ObjectOutputStream {
MiClaseOutput(FileOutputStream f) throws IOException{
super(f);
}
 protected void writeStreamHeader() throws IOException{}
}