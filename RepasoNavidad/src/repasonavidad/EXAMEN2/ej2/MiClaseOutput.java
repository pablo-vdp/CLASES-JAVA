package repasonavidad.EXAMEN2.ej2;

import java.io.*;

public class MiClaseOutput extends ObjectOutputStream {
MiClaseOutput(FileOutputStream f) throws IOException{
super(f);
}
 protected void writeStreamHeader() throws IOException{}
}
