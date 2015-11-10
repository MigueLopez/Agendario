/*
 * Clase para definir tipo de dato fecha
 */
package Agendario.Datos;

/**
 *
 * @author migue_000
 */
public class Fecha {
        private int dia;
        private int mes;
        private int anio;
        
        public Fecha(int dia, int mes, int anio){
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        }
        
        //Constructor Vacio
        public Fecha(){
            //En el constructor inicializa la fecha al 01/01/2015
            dia = 1;
            mes = 1;
            anio = 2015;
        }
        
        public int getDia(){
            return dia;
        }
        
        public int getMes(){
            return mes;
        }
        
        public int getAnio(){
            return anio;
        }
        
        public boolean setDia(int dia){
            if(verificaFecha(dia,this.mes,this.anio)){
                this.dia = dia;
                return true;
            }
            else{
                return false;
            }
        }
        
        public boolean setMes(int mes){
            if(verificaFecha(this.dia,mes,this.anio)){
                this.mes = mes;
                return true;
            }
            else{
                return false;
            }
        }
        
        public boolean setAnio(int anio){
            if(verificaFecha(this.dia,this.mes,anio)){
                this.anio = anio;
                return true;
            }
            else{
                return false;
            }
        }
        
        private boolean verificaFecha(int dia, int mes, int anio){
            boolean esBisiesto;
            int diasMes;
            
            //Para que sea año bisieto tiene que se multiplo de 400 ó multiplo de 4 excluyendo multiplos de 100
            esBisiesto = false;
            if( (anio%400 == 0) || ((anio%4 == 0) && (anio%100 > 0)) ){
                esBisiesto = true;
            }
            
            //No hay meses ni dias cero o negativos, o mas de 12 mese
            if( dia <= 0  || mes <= 0 || mes > 12 ){
                return false;
            }
            
            //Tomar el numero maximo de dias segun el mes
            switch(mes){
                case 1 :
                case 3 : 
                case 5 :
                case 7 :
                case 8 :
                case 10:
                case 12:                    
                        diasMes = 31;
                        break;
                    
                case 2: diasMes = (esBisiesto)?29:28;  //Si es año bisiesto febrero tiene 29 dias
                        break;
                    
                default: diasMes = 30;
                         break;
            }
            
            if( dia > diasMes ){
                return false;
            }
            
            return true;            
        }
    
}
