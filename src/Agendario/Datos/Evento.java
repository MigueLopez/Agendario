/*
 * Clase con los atributos de la clase Evento
 */
package Agendario.Datos;

/**
 *
 * @author Miguel Ángel López Cervantes
 */
public class Evento {
    private int idEvento;
    private String titulo;
    private String notas;
    private Fecha fecha;
    private int hora;
    private int idUsuario;
    private int idTipoEvento;
    private int idMateria;
    
    public Evento(int idEvento, String titulo, String notas, Fecha fecha, int hora, int idUsuario, int idTipoEvento, int idMateria){
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.notas = notas;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idTipoEvento = idTipoEvento;
        this.idMateria = idMateria;
    }
    
    /*Constructor con fecha separada*/
    public Evento(int idEvento, String titulo, String notas, int dia, int mes, int anio, int hora, int idUsuario, int idTipoEvento, int idMateria){
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.notas = notas;
        this.fecha = new Fecha(dia,mes,anio);
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idTipoEvento = idTipoEvento;
        this.idMateria = idMateria;
    }
    
    
    /*Constructores sin ID*/
    public Evento(String titulo, String notas, Fecha fecha, int hora, int idUsuario, int idTipoEvento, int idMateria){
        this.idEvento = -1;
        this.titulo = titulo;
        this.notas = notas;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idTipoEvento = idTipoEvento;
        this.idMateria = idMateria;
    }
    
    /*Constructor con fecha separada*/
    public Evento(String titulo, String notas, int dia, int mes, int anio, int hora, int idUsuario, int idTipoEvento, int idMateria){
        this.idEvento = -1;
        this.titulo = titulo;
        this.notas = notas;
        this.fecha = new Fecha(dia,mes,anio);
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idTipoEvento = idTipoEvento;
        this.idMateria = idMateria;
    }
    
    /*Constructor vacio*/
    public Evento(){
        this.idEvento = -1;
        this.titulo = "";
        this.notas = "";
        this.fecha = new Fecha();
        this.hora = 0;
        this.idUsuario = -1;
        this.idTipoEvento = -1;
        this.idMateria = -1;
    }
    
    public void setIdEvento(int idEvento){
        this.idEvento = idEvento;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setNotas(String notas){
        this.notas = notas;
    }
    
    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }
    
    public void setFecha(int dia, int mes, int anio){
        this.fecha = new Fecha(dia,mes,anio);
    }
    
    public void setHora(int hora){
        this.hora = hora;
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public void setIdTipoEvento(int idTipoEvento){
        this.idTipoEvento = idTipoEvento;
    }
    
    public void setIdMateria(int idMateria){
        this.idMateria = idMateria;
    }
    
    public int getIdEvento(){
        return this.idEvento;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getNotas(){
        return this.notas;
    }
    
    public Fecha getFecha(){
        return this.fecha;
    }
    
    public int getHora(){
        return this.hora;
    }
    
    public int getIdUsuario(){
        return this.idUsuario;
    }
    
    public int getIdTipoEvento(){
        return this.idTipoEvento;
    }
    
    public int getIdMaterie(){
        return this.idMateria;
    }
    
}