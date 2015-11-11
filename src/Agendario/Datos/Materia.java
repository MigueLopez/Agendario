/*
 * Clase con los atributos de la tabla materia
 */
package Agendario.Datos;

import java.sql.*;
import Agendario.Conexion.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class Materia {
    private int idMateria;
    private String clave;
    private String nombre;
    private int idUsuario;
    private Clase[] clases;
    
    public Materia(int idMateria, String clave, String nombre, int idUsuario, Clase[] clases){
        this.idMateria = idMateria;
        this.clave = clave;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.clases = clases;        
    }
    
    /*Constructor sin Id*/
    public Materia(String clave, String nombre, int idUsuario, Clase[] clases){
        this.idMateria = -1;
        this.clave = clave;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.clases = clases;        
    }
    
    /*Constructor vacio*/
    public Materia(){
        this.idMateria = -1;
        this.clave = "";
        this.nombre = "";
        this.idUsuario = -1;
        this.clases = null;        
    }
    
    public void setIdMateria(int idMateria){
        this.idMateria = idMateria;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public void setClases(Clase[] clases){
        this.clases = clases;
    }
    
    public int getIdMateria(){
        return this.idMateria;
    }
    
    public String getClave(){
        return this.clave;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getIdUsuario(){
        return this.idUsuario;
    }
    
    public Clase[] getClases(){
        return this.clases;
    }
    
    public static boolean validaClave(String clave){
        ResultSet rs;
        
        rs = ConexionPostgreSQL.obtenerRegistro("Materia", "clave = '" + clave + "'");
        
        try {
            if(rs.next()){  //Si encuentra algun registro la clave ya esta repetida
                JOptionPane.showMessageDialog(null, "Ya hay un registro de materia con clave: " + clave);
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar registro: " + ex.getMessage());
        }
        
        return false;
    }
    
    public void inserta(){
        Connection con;
        String qry;
        
        con = ConexionPostgreSQL.getConexion();
        
        if(con != null){
            try{
                idMateria = GeneradorPK.dameSiguientePK("idmateria", "materia");
                Statement st = con.createStatement();
                qry = "INSERT INTO materia VALUES("+String.valueOf(idMateria)+",'"+nombre+"','"+clave+"',"+String.valueOf(idUsuario)+")";
                st.execute(qry);
                insertarClases();
                JOptionPane.showMessageDialog(null,"La Materia se agrego correctamente");
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
                qry = "UPDATE materia SET materia = '" + nombre + "', clave = '" + clave + "' WHERE idmateria = " + String.valueOf(idMateria); ;
                st.execute(qry);
                borrarClases();
                insertarClases();
                JOptionPane.showMessageDialog(null,"La Materia se actualizó correctamente");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
        }
        
    }
    
    private void borrarClases(){
        Connection con = ConexionPostgreSQL.getConexion();
        String query;
        
        if(con != null){
            try{
                Statement st = con.createStatement();
                query = "DELETE FROM clase WHERE idMateria = " + idMateria;  //borrar todos los registros de clases
                st.execute(query);     
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
        }
    }
    
    private void insertarClases(){
        for(int i=0 ; i<5 ; i++){
            if(clases[i] != null){
                clases[i].inserta(idMateria);
            }
        }
        
    }
}
