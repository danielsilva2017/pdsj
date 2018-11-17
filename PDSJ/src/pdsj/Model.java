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
import java.util.TreeMap;
import static pdsj.OtherFunctions.fashionPrint;
import static pdsj.OtherFunctions.fromSecondsToHours;

public class Model {
    
    private TreeMap<LocalDate, TreeMap<LocalTime, Appointment>> marcacoes;
    
    //Funçoes controller1
    
    public void test(){
        System.out.println("view1");
        
    }
    
    /**
     * Esta função adiciona uma nova marcação, de meia hora à lista de marcações
     * @param dia dia da marcação
     * @param horaInicio hora a que a marcação começa
     * @param descricao descrição da marcação
     */
    public void makeAppointment(LocalDate dia, LocalTime horaInicio, String descricao){
        if (!marcacoes.containsKey(dia)) marcacoes.put(dia, new TreeMap<>());
        TreeMap<LocalTime, Appointment> valores = marcacoes.get(dia);
        valores.put(horaInicio, new Appointment(dia, horaInicio, horaInicio.plusMinutes(30), descricao));
        marcacoes.put(dia, valores);
    }
    /**
     * Esta função devolve as marcações de um determinado dia
     * @param dia data das marcações a retornar
     * @return mapa das marcações do dia
     */
    public TreeMap<LocalTime, Appointment> seeAppointments(LocalDate dia){
        return marcacoes.get(dia);
    }
    /**
     * Esta função elimina uma marcação
     * @param dia data da marcação a eliminar
     * @param horaInicio hora de início da marcação
     */
    public void deleteApppointment(LocalDate dia, LocalTime horaInicio){
        TreeMap<LocalTime, Appointment> valores = marcacoes.get(dia);
        valores.remove(horaInicio);
        marcacoes.put(dia, valores);
    }
    /**
     * Esta função verifica se já existe uma marcação num determinado intervalo de horas
     * @param dia data da marcação a eliminar
     * @param horaInicio hora de início do intervalo a verificar
     * @param horaFim hora do fim do intervalo a verificar
     * @return true se não houver nenhuma marcação no intervalo, false se houver
     */
    public boolean verificarDisponibilidadeMarcacao(LocalDate dia, LocalTime horaInicio, LocalTime horaFim){
       TreeMap<LocalTime, Appointment> values = marcacoes.get(dia);
       while (horaInicio != horaFim){
           LocalTime newStartTime = horaFim.minusMinutes(30);
           if (values.containsKey(newStartTime)) return false;
           horaFim = newStartTime;
       }
       return true;
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
