/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static pdsj.App.formatDate;

/**
 *
 * @author silva
 */
public class OtherFunctions {
    public static void fashionPrint(ZonedDateTime arrive){
        LocalDate data = arrive.toLocalDate();
        LocalTime horas = arrive.toLocalTime();
        ZoneId id = arrive.getZone();
        System.out.println("Chegará a "+id+" por volta das "+horas+" locais, na data "+data);
    }
    public static String [] parseDate(String str ){
        
        String [] res =str.split("-");
        return res;
    }
     public static String [] parseHours(String str ){
        
        String [] res =str.split(":");
        return res;
    }
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
    public static void fromSecondsToHours(long i){
        if(i<0){
            i=i*-1;
        }
        long hours = i/3600;
        long rest = i-(hours*3600);
        long minutes=rest/60;
        System.out.println("Horas "+hours +" e minutos "+minutes);
    }
}
