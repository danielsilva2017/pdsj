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
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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
        Duration x = Duration.between(nowz,nowz2);
          long a = x.getSeconds();
        fromSecondsToHours(a);
    }
   
    
    //Funçoes controller3
    
    public void test3(){
        System.out.println("view3");
    }
    /**
     * Esta função calcula quantos anos, meses e dias existem de diferença entre duas datas.
     * @param data1 data inicial
     * @param data2 data final
     */
    public void contasDatas(LocalDate data1, LocalDate data2){
        Period p = Period.between(data1, data2);
        Period p1 = p.normalized();
        System.out.println("Diferença de datas -> Anos " + p1.getYears()+ 
                            "; Meses " + p1.getMonths() + "; Dias " + p1.getDays());
    }
    /**
     * Esta função calcula quantas horas, minutos e seguntos existem de diferença entre duas horas.
     * @param hora1 hora inicial
     * @param hora2 hora final
     */
    public void contasHoras(LocalTime hora1, LocalTime hora2){
        int h = 0;
        int m = 0;
        int s = 0;
        
        
        if(hora1.getHour() > hora2.getHour())
            h = hora1.getHour() - hora2.getHour();
        else
            h = hora2.getHour() - hora1.getHour();
        
        if(hora1.getMinute() > hora2.getMinute())
            m = hora1.getMinute() - hora2.getMinute();
        else
            m = hora2.getMinute() - hora1.getMinute();
        
        if(hora1.getSecond() > hora2.getSecond())
            s = hora1.getSecond() - hora2.getSecond();
        else
            s = hora2.getSecond() - hora1.getSecond();
        
        
        
        LocalTime ht = LocalTime.of(h, m, s);
        System.out.println("Diferença de datas -> Horas " + ht.getHour() + 
                            "; Minutos " + ht.getMinute() + "; Segundos " + ht.getSecond());
    }
    /**
     * Esta função calcula quantos anos, meses, dias, horas, minutos e seguntos existem 
     * de diferença entre duas datas com as horas associadas.
     * @param data1 data inicial
     * @param data2 data final
     * @param hora1 hora inicial
     * @param hora2 hora final
     */
    public void contasDatasHoras(LocalDate data1, LocalDate data2, LocalTime hora1, LocalTime hora2){
        Period p = Period.between(data1, data2);
        Period p1 = p.normalized();
        
        int h = 0;
        int m = 0;
        int s = 0;
        
        if(hora1.getHour() > hora2.getHour())
            h = hora1.getHour() - hora2.getHour();
        else
            h = hora2.getHour() - hora1.getHour();
        
        if(hora1.getMinute() > hora2.getMinute())
            m = hora1.getMinute() - hora2.getMinute();
        else
            m = hora2.getMinute() - hora1.getMinute();
        
        if(hora1.getSecond() > hora2.getSecond())
            s = hora1.getSecond() - hora2.getSecond();
        else
            s = hora2.getSecond() - hora1.getSecond();
        
        
        LocalTime ht = LocalTime.of(h, m, s);
        System.out.println("Diferença de datas -> Anos " + p1.getYears()+ 
                            "; Meses " + p1.getMonths() + "; Dias " + p1.getDays() + ";\n "
                         + "                     Horas " + ht.getHour() + 
                            "; Minutos " + ht.getMinute() + "; Segundos " + ht.getSecond());
    }
    /**
     * Esta função adiciona valores a uma data.
     * @param data data original
     * @param ano quantidade de anos a adicionar à data
     * @param mes quantidade de meses a adicionar à data
     * @param dias quantidade de dias a adicionar à data
     */
    public void addDatas(LocalDate data, int ano, int mes, int semana, int dias){
        LocalDate data2 = data.plusYears(ano).plusMonths(mes).plusWeeks(semana).plusDays(dias);
        System.out.println("Nova data -> Ano " + data2.getYear() + 
                            "; Mês " + data2.getMonth() + "; Dia " + data2.getDayOfMonth());
    }
    /**
    * Esta função subtraí valores a uma data.
    * @param data data original
    * @param ano quantidade de anos a subtrair à data
    * @param mes quantidade de meses a subtrair à data
    * @param dias quantidade de dias a subtrair à data
    */
    public void subDatas(LocalDate data, int ano, int mes, int semana, int dias){
        LocalDate data2 = data.minusYears(ano).minusMonths(mes).minusWeeks(semana).minusDays(dias);
        System.out.println("Nova data -> Ano " + data2.getYear() + 
                            "; Mês " + data2.getMonth() + "; Dia " + data2.getDayOfMonth());
    }
}
