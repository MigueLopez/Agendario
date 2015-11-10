/*
 * Clase con los atributos de la tabla materia
 */
package Agendario.Datos;

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
}
