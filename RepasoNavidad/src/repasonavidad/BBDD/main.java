/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.BBDD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class main {
    public void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // ver si tengo la clase
            System.out.println("OK");
            
//conectar BBDD
            Connection conn; 
            conn=DriverManager.getConnection("jdbc:mysql://localhost/Tienda","root","");
            
            mostrar_Tabla_Fabricantes(conn);
            
            añadir_Fabricante(conn);
            
            mostrar_Tabla_Fabricantes(conn);
            
            borrar_Registro(conn);
            
            mostrar_Tabla_Fabricantes(conn);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void borrar_Registro(Connection conn) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("DELETE FROM FABRICANTES WHERE NOMBRE = ?");
        pst.setString(1, "Samsung"); // set/get(pos,vlr)
        pst.executeUpdate();
    }

    private static void añadir_Fabricante(Connection conn) throws SQLException {
        //Meter datos en tabla
        PreparedStatement pst = conn.prepareStatement("INSERT INTO FABRICANTES VALUES (?,?)");
        pst.setInt(1, 6);
        pst.setString(2, "Samsung");
        pst.executeUpdate();
    }

    private static void mostrar_Tabla_Fabricantes(Connection conn) throws SQLException {
        //preparar sentencia SQL
        PreparedStatement pst =conn.prepareStatement("SELECT * FROM FABRICANTES ");
//ejecutar sentencia => exQuery (Select...) exUpdate(INSERT/DELETE/UPDATE)
ResultSet rs = pst.executeQuery();
//mientras queden registros de la sentencia
while(rs.next()){
    System.out.println("ID "+rs.getInt(1)+ " Nombre: "+rs.getString(2));
}
    }
}
