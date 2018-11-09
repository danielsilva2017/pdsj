/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.HOURS;
import java.time.temporal.TemporalUnit;
import static pdsj.OtherFunctions.fashionPrint;
import static pdsj.OtherFunctions.fromSecondsToHours;

/**
 *
 * @author silva
 */
public class Model {
    //Funçoes controller1
    
    public void test(){
        System.out.println("view1");
        
    }
    
    //Funçoes controller2
    
    public void test2(){
        System.out.println("view2");
    }
    /**
     * Esta função usa a função queHorasSerao() da classe Model para calcular que horas serão 
     * quando aterrar.
     * @param year ano da viagem de partida
     * @param month mes da viagem de partida
     * @param day dia da viagem de partida
     * @param hour hora local de partida
     * @param minutes minutes locais de partida
     * @param zonaPartida zona local
     * @param zonaChegada zona de Chegada
     * @param hoursFlight horas de duração da viagem
     * @param minutesFlight minutos de duração de viagem
     * @see  LocalDateTime#of(java.time.LocalDate, java.time.LocalTime) 
     * @see ZoneId#of(java.lang.String) 
     * @see ZonedDateTime#of(java.time.LocalDateTime, java.time.ZoneId) 
     * @see OtherFunctions#fashionPrint(java.time.ZonedDateTime) 
     * 
     */
    public void queHorasSerao(int year,Month month,int day,int hour,int minutes,String zonaPartida,String zonaChegada,int hoursFlight,int minutesFlight ){ 
        LocalDateTime dataDePartida= LocalDateTime.of(year,month,day,hour,minutes);
        ZoneId zonaDePartida = ZoneId.of(zonaPartida);
        ZonedDateTime partida = ZonedDateTime.of(dataDePartida,zonaDePartida);
        ZoneId zonaDeChegada = ZoneId.of(zonaChegada);
        ZonedDateTime chegada = partida.withZoneSameInstant(zonaDeChegada).plusHours(hoursFlight).plusMinutes(minutesFlight);
        fashionPrint(chegada);
        
    }
    public void horasPais(String zoneId){
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zoneId));
        LocalDate data = now.toLocalDate();
        LocalTime horas = now.toLocalTime();
        ZoneId id = now.getZone();
        System.out.println("Sao "+horas+" em "+id+" na data "+data);
        
    }
    public void  diferençaHoras(String zoneId,String zoneId2){
        LocalDateTime now = LocalDateTime.now();
        ZoneId fusoN=ZoneId.of(zoneId);
        LocalDateTime now2 = LocalDateTime.now();
        ZoneId fusoN2=ZoneId.of(zoneId2);
        ZonedDateTime nowz = ZonedDateTime.of(now,fusoN);
        ZonedDateTime nowz2 = ZonedDateTime.of(now2,fusoN2);
        System.out.println(nowz + "  " + nowz2);
        Duration x = Duration.between(nowz,nowz2);
          long a = x.getSeconds();
        fromSecondsToHours(a);
    }
   
    
    //Funçoes controller3
    
    public void test3(){
        System.out.println("view3");
    }
    
}
