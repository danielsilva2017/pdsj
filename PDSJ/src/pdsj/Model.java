/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import java.util.TreeMap;

public class Model {
    
    private TreeMap<LocalDate, TreeMap<LocalTime, Appointment>> marcacoes = new TreeMap<>();
    
    //Funçoes controller1
    
    
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
        if (valores==null) {
        	return;
        }
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
       if (values==null) {
    	   return true;
       }
       while (horaInicio != horaFim){
           LocalTime newStartTime = horaFim.minusMinutes(30);
           if (values.containsKey(newStartTime)) return false;
           horaFim = newStartTime;
       }
       return true;
    }
    //Funçoes controller2
    
    /**
     * Esta função calcula que horas serão quando o avião aterrar
     * @param dataDePartida data e hora da partida do vôo
     * @param zonaPartida zona local
     * @param zonaChegada zona de Chegada
     * @param hoursFlight horas de duração da viagem
     * @return ZonedDateTime
     * @see  LocalDateTime#of(java.time.LocalDate, java.time.LocalTime) 
     * @see ZoneId#of(java.lang.String) 
     * @see ZonedDateTime#of(java.time.LocalDateTime, java.time.ZoneId) 
     * 
     */
    public ZonedDateTime queHorasSerao(LocalDateTime dataDePartida,String zonaPartida,String zonaChegada,LocalTime hoursFlight ){ 
        ZoneId zonaDePartida = ZoneId.of(zonaPartida);
        ZonedDateTime partida = ZonedDateTime.of(dataDePartida,zonaDePartida);
        ZoneId zonaDeChegada = ZoneId.of(zonaChegada);
        ZonedDateTime chegada = partida.withZoneSameInstant(zonaDeChegada).plusHours(hoursFlight.getHour()).plusMinutes(hoursFlight.getMinute());
        return chegada;
        
    }
    /**
     * Esta função calcula que horas serão quando o avião aterrar
     * @param partida hora e data de partida
     * @param zonaPartida zona local
     * @param zonaChegada zona de Chegada
     * @param chegada hora e data de chegada
     * @see  LocalDateTime#of(java.time.LocalDate, java.time.LocalTime) 
     * @see ZoneId#of(java.lang.String) 
     * @see ZonedDateTime#of(java.time.LocalDateTime, java.time.ZoneId) 
     * @return 
     */
    public long duracaoVoo(LocalDateTime partida,String zonaPartida,String zonaChegada, LocalDateTime chegada ){ 
	ZoneId fusoHorarioPartida = ZoneId.of(zonaPartida);
	ZoneId fusoHorarioChegada = ZoneId.of(zonaChegada);
        ZonedDateTime saidaComFusoHorario =ZonedDateTime.of(partida, fusoHorarioPartida);
        ZonedDateTime chegadaComFusoHorario = 	ZonedDateTime.of(chegada, fusoHorarioChegada);
        Duration duracaoDoVoo =  Duration.between(saidaComFusoHorario, chegadaComFusoHorario);
        long a = duracaoDoVoo.getSeconds();
        return a;
        
    }
    
    
    /**
     * Esta função calcula as horas num certo país
     * @param zoneId zona do país  
     * @see ZoneId#of(java.lang.String) 
     * @see ZonedDateTime#of(java.time.LocalDateTime, java.time.ZoneId) 
     * 
     * 
     */
    public String horasPais(String zoneId){
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zoneId));
        LocalDate data = now.toLocalDate();
        LocalTime horas = now.toLocalTime();
        ZoneId id = now.getZone();
        return "Sao "+horas+" em "+id+" na data "+data;
        
    }
    /**
     * Esta função calcula a diferença de horas entre dois países
     * @param zoneId zona do país 1
     * @param zoneId2 zona do país 2
     * @see ZoneId#of(java.lang.String) 
     * @see ZonedDateTime#of(java.time.LocalDateTime, java.time.ZoneId) va.time.Duration)
     * 
     */
    public long diferencaHoras(String zoneId,String zoneId2){
        LocalDateTime now = LocalDateTime.now();
        ZoneId fusoN=ZoneId.of(zoneId);
        LocalDateTime now2 = LocalDateTime.now();
        ZoneId fusoN2=ZoneId.of(zoneId2);
        ZonedDateTime nowz = ZonedDateTime.of(now,fusoN);
        ZonedDateTime nowz2 = ZonedDateTime.of(now2,fusoN2);
        Duration x = Duration.between(nowz,nowz2);
        long a = x.getSeconds();
        return a;
    }
   
    
    //Funçoes controller3
    
    /**
     * Esta função calcula qual o dia do mês do ano dado duma determinada semana 
     * com um certo dia da semana.
     * @param ano
     * @param mes que define qual o mês do ano
     * @param semana que pode ter valor entre 1 e 4, inclusive
     * @param diaDaSemana que pode ter o valor SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SÁBADO ou DOMINGO
     * @return String com a informação do dia do mês pedido
     */
    public String contasMes(int ano, int mes, int semana, String diaDaSemana){
        YearMonth ym = YearMonth.of(LocalDate.now().getYear(), mes);
        DayOfWeek dow = OtherFunctions.getWeek(diaDaSemana);
        String f;
        String mes2 = OtherFunctions.getMes(mes);
       
        LocalDate diaSem = ym.atDay(1).plusWeeks(semana-1).with(firstInMonth(dow));
        
        if(diaDaSemana.endsWith("A")){
            f = "A " + diaDaSemana.toLowerCase();
        } else{
            f = "O " + diaDaSemana.toLowerCase();
        }
        
        return f  + " da " + semana + "ª semana de " + mes2 + " do ano " + ano + " ocorre no dia " + diaSem.getDayOfMonth();
    }
    
    /**
     * Esta função calcula quantos anos, meses e dias existem de diferença entre duas datas.
     * @param data1 data inicial
     * @param data2 data final
     * @return Period
     */
    public Period contasDatas(LocalDate data1, LocalDate data2){
        Period p = Period.between(data1, data2);
        Period p1 = p.normalized();
        
        return p1;
    }
    /**
     * Esta função calcula quantas horas, minutos e seguntos existem de diferença entre duas horas.
     * @param hora1 hora inicial
     * @param hora2 hora final
     * @return LocalTime
     */
    public LocalTime contasHoras(LocalTime hora1, LocalTime hora2){
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
        
        
        return LocalTime.of(h, m, s);
    }
    /**
     * Esta função calcula quantos anos, meses, dias, horas, minutos e seguntos existem 
     * de diferença entre duas datas com as horas associadas.
     * @param data1 data inicial
     * @param data2 data final
     * @param hora1 hora inicial
     * @param hora2 hora final
     * @return String
     */
    public String contasDatasHoras(LocalDate data1, LocalDate data2, LocalTime hora1, LocalTime hora2){
        Period p1 = contasDatas(data1, data2);
        LocalTime ht = contasHoras(hora1, hora2);
        
        return "Diferença de datas -> Anos " + p1.getYears()+ 
                "; Meses " + p1.getMonths() + "; Dias " + p1.getDays() + ";\n "
                + "                     Horas " + ht.getHour() +
                "; Minutos " + ht.getMinute() + "; Segundos " + ht.getSecond();
    }
    /**
     * Esta função adiciona valores a uma data.
     * @param data data original
     * @param ano quantidade de anos a adicionar à data
     * @param mes quantidade de meses a adicionar à data
     * @param dias quantidade de dias a adicionar à data
     * @param semana quantidade de semanas a adicionar à data
     * @return LocalDate
     */
    public LocalDate addDatas(LocalDate data, int ano, int mes, int semana, int dias){
        LocalDate data2 = data.plusYears(ano).plusMonths(mes).plusWeeks(semana).plusDays(dias);
        
        return data2;
    }
    /**
    * Esta função subtraí valores a uma data.
    * @param data data original
    * @param ano quantidade de anos a subtrair à data
    * @param mes quantidade de meses a subtrair à data
    * @param dias quantidade de dias a subtrair à data
    * @param semana quantidade de semanas a adicionar à data
    * @return LocalDate
    */
    public LocalDate subDatas(LocalDate data, int ano, int mes, int semana, int dias){
        LocalDate data2 = data.minusYears(ano).minusMonths(mes).minusWeeks(semana).minusDays(dias);
        
        return data2;
    }
}
