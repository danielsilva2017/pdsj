/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static pdsj.OtherFunctions.fashionPrint;

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
    public void queHorasSerao(int year,Month month,int day,int hour,int minutes,String zonaPartida,String zonaChegada,int hoursFlight,int minutesFlight ){ 
        LocalDateTime dataDePartida= LocalDateTime.of(year,month,day,hour,minutes);
        ZoneId zonaDePartida = ZoneId.of(zonaPartida);
        ZonedDateTime partida = ZonedDateTime.of(dataDePartida,zonaDePartida);
        ZoneId zonaDeChegada = ZoneId.of(zonaChegada);
        ZonedDateTime chegada = partida.withZoneSameInstant(zonaDeChegada).plusHours(hoursFlight).plusMinutes(minutesFlight);
        fashionPrint(chegada);
        
    }
    
    //Funçoes controller3
    
    public void test3(){
        System.out.println("view3");
    }
    
}
