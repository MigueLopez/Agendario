/*
 * Clase con los atributos de la Tabla Clase
 */
package Agendario.Datos;

import javax.swing.*;
import java.sql.*;
import Agendario.Conexion.*;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class Clase {
    private int idClase;
    private String dia;
    private int horaInicio;
    private int horaFin;
    
    public Clase(int idClase,String dia, int horaInicio, int horaFin){
        this.idClase = idClase;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    /* Consttructor sin Id*/
    public Clase(String dia, int horaInicio, int horaFin){
        this.idClase = -1;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    /*Constructor vacio*/
    public Clase(){
        this.idClase = -1;
        this.dia = "";
        this.horaInicio = 0;
        this.horaFin = 0;
    }
    
    public void setID(int idClase){
        this.idClase = idClase;
    }
    
    public void setDia(String dia){
        this.dia = dia;
    }
    
    public void setHoraInicio(int horaInicio){
        this.horaInicio = horaInicio;
    }
    
    public void setHoraFin(int horaFin){
        this.horaFin = horaFin;
    }
    
    public int getID(){
        return this.idClase;
    }
    
    public String getDia(){
        return this.dia;
    }
    
    public int getHoraInicio(){
        return this.horaInicio;
    }
    
    public int getHoraFin(){
        return this.horaFin;
    }
    
    public void inserta(int idMateria){
        Connection con;
        String qry;
        
        con = ConexionPostgreSQL.getConexion();
        
        if(con != null){
            try{
                idClase = GeneradorPK.dameSiguientePK("idclase", "clase");
                Statement st = con.createStatement();
                qry = "INSERT INTO clase VALUES("+String.valueOf(idClase)+"," + String.valueOf(idMateria) + ",'"+dia+"',"+horaInicio+","+horaFin+")";
                st.execute(qry);
                //System.out.println("La clase se agrego correctamente");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error al insertar clase: " + e.getMessage());
            }
        }
        
    }
    
}
