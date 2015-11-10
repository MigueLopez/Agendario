/*
 * Clase para generar automaticamente las llaves primarias
 */
package Agendario.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class GeneradorPK {
    
    public static int dameSiguientePK(String campo,String tabla){
        Connection con;
        String qry;
        int pk = 1;  //Si no encuentra ningun registro asignara 1 como llave primaria
        
        con = ConexionPostgreSQL.getConexion();
        
        if(con != null){
            try{
                Statement st = con.createStatement();
                qry = "SELECT " + campo + " FROM " + tabla + " ORDER BY " + campo + " DESC LIMIT 1";
                ResultSet rs = st.executeQuery(qry);
                if(rs.next()){
                    pk = rs.getInt(1) + 1;  //Aumentamos uno para asignar la nueva llave primaria
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error al obtener llave primaria: " + e.getMessage());
            }
        }
        
        return pk;
    }
    
    
    
}
