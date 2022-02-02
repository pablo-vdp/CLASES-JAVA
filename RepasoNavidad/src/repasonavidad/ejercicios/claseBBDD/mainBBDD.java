/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasonavidad.ejercicios.claseBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class mainBBDD {
    public void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
            Connection conn;
            conn= DriverManager.getConnection("jdbc:mysql://localhost/Tienda","root","");
            
          /*  int IDmax = 0 ;
            
            IDmax = ult_ID(conn, IDmax);
           
             Scanner sc = new Scanner(System.in);
             System.out.println("Inserte el nombre del Fabricante");
             String entrada = sc.nextLine();
             System.out.println("Fabricante seleccionado:"+entrada);
             
            
           // nuevo_Fabricante(conn, IDmax);
           
            int ID_Fab = buscar_ID_FAB(conn,entrada);*/
            
            // borrar_fabricante(conn, ID_Fab);
             
             
             
            mod_precio(conn);
            
           // mostrar_articulos_x_fab(conn, ID_Fab);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mainBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void mod_precio(Connection conn) throws SQLException, NumberFormatException {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Inserte ID del producto");
        int Id = sc2.nextInt();
       
        
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Indique su valor");
        int Precio = sc3.nextInt();
        
        
        PreparedStatement pst = conn.prepareStatement("UPDATE ARTICULOS SET PRECIO=? WHERE CLART=?");
        pst.setInt(2, Id);
        pst.setInt(1, Precio);
        
        pst.executeUpdate();
        
    }

    private static void mostrar_articulos_x_fab(Connection conn, int ID_Fab) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM ARTICULOS WHERE CLFAB = ?");
        pst.setInt(1, ID_Fab);
        
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString(2));
        }
    }

    private static void borrar_fabricante(Connection conn, int ID_Fab) throws SQLException {
        //ver si hay articulos del fabricante y borrar
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM ARTICULOS WHERE CLFAB = ?");
        pst.setInt(1, ID_Fab);
        ResultSet artsIDfab = pst.executeQuery();
        
        if(artsIDfab.next() == true){
            while(artsIDfab.next()){
                System.out.println(artsIDfab.getString(2));
            }
        }else{
            System.out.println("No hay articulos de esa marca");
            PreparedStatement pst1 = conn.prepareStatement("DELETE FROM FABRICANTES WHERE CLFAB = ?");
            pst1.setInt(1, ID_Fab ); // set/get(pos,vlr
            pst1.executeUpdate();
            
            System.out.println("Fabricante eliminado");
        }
    }

    private static int buscar_ID_FAB(Connection conn, String entrada) throws SQLException {
        //Eliminir Fabricante
        //buscar id del fabricante
        PreparedStatement pst2 = conn.prepareStatement("SELECT CLFAB FROM FABRICANTES WHERE NOMBRE = ?");
        pst2.setString(1, entrada);
        ResultSet rs = pst2.executeQuery();
        int ID_Fab=0;
        while(rs.next()){
            ID_Fab = rs.getInt(1) ;
        }
        System.out.println(ID_Fab);
        return ID_Fab;
    }

    private static int ult_ID(Connection conn, int IDmax) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("SELECT CLFAB FROM FABRICANTES");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            if(IDmax < rs.getInt(1))
                IDmax = rs.getInt(1);
        }
        return IDmax;
    }

    private static void nuevo_Fabricante(Connection conn, int IDmax) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO FABRICANTES VALUES (?,?)");
        pst.setInt(1, IDmax+1);
        pst.setString(2, "Marca");
        pst.executeUpdate();
    }



}
