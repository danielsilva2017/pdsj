/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author silva
 */
public class OtherFunctions {
    /**
     * Esta função imprime no ecra as horas, minutos e dias que chegará o avião
     * @param arrive Zona do mundo
     */
    public static void fashionPrint(ZonedDateTime arrive){
        LocalDate data = arrive.toLocalDate();
        LocalTime horas = arrive.toLocalTime();
        ZoneId id = arrive.getZone();
        System.out.println("Chegará a "+id+" por volta das "+horas+" locais, na data "+data);
    }
      /**
     * Esta função faz parsing da data
     * @param str data em formato String
     * @return do array com cada parte da data ( dia,mês e ano)
     */
    public static String [] parseDate(String str ){
        
        String [] res =str.split("-");
        return res;
    }
     /**
     * Esta função faz parsing da data
     * @param str hora em formato String
     * @return do array com cada parte da hora(horas e minutos)
     */
     public static String [] parseHours(String str ){
        
        String [] res =str.split(":");
        return res;
    }
     /**
     * Esta função transforma o mês inserido em forma numérica em formato java.time.Month
     * @param i numero do mês
     * @return do mês
     */
    public static Month getMonth(int i){
        Month x = Month.JANUARY;
        switch(i) {
                case 1 : x=Month.JANUARY;break;
                case 2 : x=Month.FEBRUARY;break;
                case 3 : x=Month.MARCH;break;
                case 4 : x=Month.APRIL;break;
                case 5 : x=Month.MAY;break;
                case 6 : x=Month.JUNE;break;
                case 7 : x=Month.JULY;break;
                case 8 : x=Month.AUGUST;break;
                case 9 : x=Month.SEPTEMBER;break;
                case 10 : x=Month.OCTOBER;break;
                case 11 : x=Month.NOVEMBER;break;
                case 12 : x=Month.DECEMBER;break;
                
                default: System.out.println("Opcão Inválida !"); break;
        }
        return x;
    }
     /**
     * Esta função imprime a transformação de um dado número de segundos em horas e minutos
     * @param i número de segundos
     * 
     */
    public static void segundosParaHoras(long i,char v){
        String a = "mais";
        if(i<0){
            i=i*-1;
            a="menos";
        }
        long hours = i/3600;
        long rest = i-(hours*3600);
        long minutes=rest/60;
         switch(v) {
                case 'a':System.out.println("A diferença horária é de "+a+" "+hours +" horas e "+minutes+" minutos"); break;
                case 'b':System.out.println("A duração do voo é de "+hours+" horas e "+minutes+" minutos."); break;
                default: break;
            }
        
    }
    
    /**
     * Esta função transforma o mês inserido em forma numérica em formato em String
     * @param mes número do mês
     * @return String com o nome do mês
     */
    public static String getMes(int mes){
        String mes2 = "";
        switch(mes){
            case 1:  mes2 = "Janeiro";      break;
            case 2:  mes2 = "Fevereiro";    break;
            case 3:  mes2 = "Março";        break;
            case 4:  mes2 = "Abril";        break;
            case 5:  mes2 = "Maio";         break;
            case 6:  mes2 = "Junho";        break;
            case 7:  mes2 = "Julho";        break;
            case 8:  mes2 = "Agosto";       break;
            case 9:  mes2 = "Setembro";     break;
            case 10: mes2 = "Outubro";      break;
            case 11: mes2 = "Novembro";     break;
            case 12: mes2 = "Dezembro";     break;
        }
        return mes2;
    }
    /**
     * Esta função transforma o mês inserido em forma de String em formato java.time.DayOfWeek
     * @param diaDaSemana dia da semana (ex.: SEGUNDA)
     * @return DayOfWeek que é o dia da semana
     */
    public static DayOfWeek getWeek(String diaDaSemana){
        DayOfWeek dow = DayOfWeek.MONDAY;
        
        switch(diaDaSemana) {
                case "SEGUNDA": dow = DayOfWeek.MONDAY;     break;
                case "TERÇA":   dow = DayOfWeek.TUESDAY;    break;
                case "QUARTA":  dow = DayOfWeek.WEDNESDAY;  break;
                case "QUINTA":  dow = DayOfWeek.THURSDAY;   break;
                case "SEXTA":   dow = DayOfWeek.FRIDAY;     break;
                case "SÁBADO":  dow = DayOfWeek.SATURDAY;   break;
                case "DOMINGO": dow = DayOfWeek.SUNDAY;     break;
                default: System.out.println("Opcão Inválida !"); break;
        }
        return dow;
    }
}
