/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agendario.Conexion;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author migue_000
 */
public class ConexionPostgreSQL {
    
    public static Connection getConexion(){
        Connection con;
        
        String driver = "org.postgresql.Driver"; // el nombre de nuestro driver Postgres.
        String connectString = "jdbc:postgresql://localhost:5432/Agendario"; // llamamos nuestra bd
        String user = "postgres"; 
        String password = "miguel"; 

        try {
            Class.forName(driver);
            //Hacemos la coneccion.
            con = DriverManager.getConnection(connectString, user, password);
            //Regresamos la conexion
            return con;
        }
        //Si se produce una Excepcion y no nos podemos conectar, muestra el sgte. mensaje.
        catch(ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }
        
        //Si no se regreso la conexión es porque hubo un error y regresamos null
        return null;
    }
    
    public static boolean conectado(Connection con){
        if(con != null){
            return true;
        }
        return false;
    }
    
    public static ResultSet obtenerRegistro(String tabla, String condicion){
        Connection con = ConexionPostgreSQL.getConexion();
        ResultSet resultado = null;
        String query;
        
        if(con != null){
            try{
                Statement st = con.createStatement();
                query = "SELECT * FROM " + tabla + " WHERE " + condicion;
                resultado = st.executeQuery(query);
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
        }
        
        return resultado;
    }
    
    public static boolean borrarRegistro(String tabla, String condicion){
        Connection con = ConexionPostgreSQL.getConexion();
        String query;
        
        if(con != null){
            try{
                Statement st = con.createStatement();
                
                //Utilizamos el SELECT para validar la existencia del registro
                query = "SELECT * FROM " + tabla + " WHERE " + condicion;
                if(st.executeQuery(query).next()){
                    //eliminamos el registro
                    query = "DELETE FROM " + tabla + " WHERE " + condicion;
                    st.execute(query);
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se encontró el registro");
                }
                
                
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
        }
        return false;
    }
    
}
