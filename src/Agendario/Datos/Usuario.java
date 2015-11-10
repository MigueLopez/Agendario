/*
 * Clase con los atributos de la tabla Usuario
 */
package Agendario.Datos;

import java.sql.*;
import Agendario.Conexion.ConexionPostgreSQL;
import Agendario.Conexion.GeneradorPK;
import javax.swing.*;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String login;
    private String password;
    
    public Usuario(int idUsuario,String nombre, String login, String password){
       this.idUsuario = idUsuario;
       this.nombre = nombre;
       this.login = login;
       this.password = password;
    }
    
    public Usuario(String nombre, String login, String password){
       this.idUsuario = -1;
       this.nombre = nombre;
       this.login = login;
       this.password = password;
    }
    
    public Usuario(){
        this.idUsuario = -1;
        this.nombre = "";
        this.login = "";
        this.password = "";
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public int getidUsuario(){
        return this.idUsuario;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void inserta(){
        Connection con;
        String qry;
        
        con = ConexionPostgreSQL.getConexion();
        
        if(con != null){
            try{
                idUsuario = GeneradorPK.dameSiguientePK("IdUsuario", "usuario");
                Statement st = con.createStatement();
                qry = "INSERT INTO Usuario VALUES("+String.valueOf(idUsuario)+",'"+nombre+"','"+login+"','"+password+"')";
                st.execute(qry);
                JOptionPane.showMessageDialog(null,"El Usuario se agrego correctamente");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
        }
        
    }
    
    
    public void actualiza(){
        Connection con;
        String qry;
        
        con = ConexionPostgreSQL.getConexion();
        
        if(con != null){
            try{
                Statement st = con.createStatement();
                qry = "UPDATE Usuario SET nombre = '" + nombre + "', login = '" + login + "', password = '" + password + "' WHERE idusuario = " + String.valueOf(idUsuario); ;
                st.execute(qry);
                JOptionPane.showMessageDialog(null,"El Usuario se actualizó correctamente");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
        }
        
    }
}
