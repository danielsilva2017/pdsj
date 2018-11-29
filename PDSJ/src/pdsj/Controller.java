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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import static pdsj.OtherFunctions.fashionPrint;
import static pdsj.OtherFunctions.parseDate;
import static pdsj.OtherFunctions.getMonth;
import static pdsj.OtherFunctions.parseHours;
import static pdsj.OtherFunctions.segundosParaHoras;

/**
 * Classe que contém as funções do controller , seguindo o modelo MVC
 */
public class Controller {
    private Model model;
    private View viewTxt;
    private Menus all = new Menus();
     /**
     * Faz set do modelo a ser usado no controller
     * @param alunos o modelo usado
     */
    public void setModel(Model alunos) { 
		model = alunos; 
    }
    /**
     * Faz set da view  a ser usada no controller
     * @param txtMenus a view usada
     */
    public void setView(View txtMenus) { 
                viewTxt = txtMenus;
                all=txtMenus.initView();
    }
     //-----------------------------Metodos-----------------------------------------------------
    
    //Metodos Calc
    /*
    * Esta função usa contasDatas da classe Model para calcular a diferença 
    * duas datas
    */
    public void datas(){
        if(Configs.formatDate.equals("Common")){
            System.out.println("Formato data: dd-mm-yyyy");
        }
        else{
            System.out.println("Formato data: yyyy-mm-dd");
        }   
        System.out.println("Insira a data inicial: ");
        LocalDate data1 = Input.lerData();
        System.out.println("Insira a data final: ");
        LocalDate data2 = Input.lerData();
        Period p1 = model.contasDatas(data1,data2);
        System.out.println("Diferença de datas -> Anos " + p1.getYears()+ 
                            "; Meses " + p1.getMonths() + "; Dias " + p1.getDays());
    }
    /*
    * Esta função usa contasHoras da classe Model para calcular a diferença 
    * duas horas
    */
    public void horas(){
        System.out.println("Insira a hora inicial: ");
        LocalTime hora1 = Input.lerHora();
        System.out.println("Insira a hora final: ");
        LocalTime hora2 = Input.lerHora();
        LocalTime ht = model.contasHoras(hora1,hora2);
        System.out.println("Diferença de datas -> Horas " + ht.getHour() + 
                            "; Minutos " + ht.getMinute() + "; Segundos " + ht.getSecond());
    }
    /*
    * Esta função usa contasDatasHoras da classe Model para calcular a diferença 
    * duas datas e horas
    */
    public void datasHoras(){
        if(Configs.formatDate.equals("Common")){
            System.out.println("ormato data: dd-mm-yyyy");
        }
        else{
            System.out.println("Formato data: yyyy-mm-dd");
        }
        System.out.println("Insira a data inicial: ");
        LocalDate data1 = Input.lerData();
        System.out.println("Insira a hora inicial: ");
        LocalTime hora1 = Input.lerHora();
        
        System.out.println("Insira a data final: ");
        LocalDate data2 = Input.lerData();
        System.out.println("Insira a hora final: ");
        LocalTime hora2 = Input.lerHora();
        System.out.println(model.contasDatasHoras(data1, data2, hora1, hora2));
    }
    /*
    * Esta função usa addDatas da classe Model para adicionar anos, meses e/ou dias 
    * a uma data
    */
    public void adicionarDatas(){
        if(Configs.formatDate.equals("Common")){
            System.out.println("Formato data: dd-mm-yyyy");
        }
        else{
            System.out.println("Formato data: yyyy-mm-dd");
        }
        System.out.println("Insira a data inicial: ");
        LocalDate data = Input.lerData();
        System.out.println("Insira valores a adicionar: ");
        System.out.println("  Anos: ");
        int ano = Input.lerInt();
        System.out.println("  Meses: ");
        int mes = Input.lerInt();
        System.out.println("  Semanas: ");
        int semana = Input.lerInt();
        System.out.println("  Dias: ");
        int dias = Input.lerInt();
        LocalDate data2 = model.addDatas(data, ano, mes, semana, dias);
        System.out.println("Nova data -> Ano " + data2.getYear() + 
                            "; Mês " + data2.getMonth() + "; Dia " + data2.getDayOfMonth());
    }
    /*
    * Esta função usa subDatas da classe Model para subtrair anos, meses, semanas e/ou dias 
    * a uma data
    */
    public void subtrairDatas(){
        if(Configs.formatDate.equals("Common")){
            System.out.println("Formato data: dd-mm-yyyy");
        }
        else{
            System.out.println("Formato data: yyyy-mm-dd");
        }
        System.out.println("Insira a data inicial: ");
        LocalDate data = Input.lerData();
        System.out.println("Insira valores a adicionar: ");
        System.out.println("  Anos: ");
        int ano = Input.lerInt();
        System.out.println("  Meses: ");
        int mes = Input.lerInt();
        System.out.println("  Semanas: ");
        int semana = Input.lerInt();
        System.out.println("  Dias: ");
        int dias = Input.lerInt();
        LocalDate data2 = model.subDatas(data, ano, mes, semana, dias);
        System.out.println("Nova data -> Ano " + data2.getYear() + 
                            "; Mês " + data2.getMonth() + "; Dia " + data2.getDayOfMonth());
    }
    
    
    //Metodos Fuso Horario
    /**
     * Esta função usa a função horasPais() da classe Model para calcular uma hora num determinado
     * país
     */
    public void horasPais(){
       System.out.println("Qual é o id do Pais? ");
       String zona= Input.lerStringZona();
       String x =model.horasPais(zona);
        System.out.println(x);
   }  
     /**
     * Esta função usa a função diferençaHoras() da classe Model para calcular a diferença de horas 
     * entre determinado dois determinados países
     */
   public void diferençaHoras(){
      System.out.println("Qual é o id do Pais 1? ");
       String zona= Input.lerStringZona();
       System.out.println("Qual é o id do Pais 2?");
       String zona2= Input.lerStringZona();
       long x=model.diferençaHoras(zona,zona2);
       segundosParaHoras(x,'a');
   }
     /**
     * Esta função usa a função duracaoVoo() da classe Model para calcular que horas serão 
     * quando aterrar 
     * 
     */
    public void duracaoVoo(){
        if(Configs.formatDate.equals("Common")){
            System.out.println("Insira a data de partida de acordo com a resolução escolhida no ficheiro de configuração (dd-mm-yyyy) :");
        }
        else{
            System.out.println("Insira a data de partida de acordo com a resolução escolhida no ficheiro de configuração (yyyy-mm-dd) :");
        }
        
        LocalDate data = Input.lerData();
        System.out.println("Insira hora de partida no formato HH:MM :");
        LocalTime hora = Input.lerHora();
        System.out.println("Insira zona de partida :");
        String zonaP= Input.lerStringZona();
        System.out.println("Insira zona de chegada :");
        String zonaC= Input.lerStringZona();
        if(Configs.formatDate.equals("Common")){
            System.out.println("Insira a data de chegada de acordo com a resolução escolhida no ficheiro de configuração (dd-mm-yyyy) :");
        }
        else{
            System.out.println("Insira a data de chegada de acordo com a resolução escolhida no ficheiro de configuração (yyyy-mm-dd) :");
        }
        LocalDate dataChegada = Input.lerData();
        System.out.println("Insira a hora de chegada HH:MM :");
        LocalTime horaChegada= Input.lerHora();
        
        long x =model.duracaoVoo(LocalDateTime.of(data, hora), zonaP, zonaC, LocalDateTime.of(dataChegada, horaChegada));
        segundosParaHoras(x,'b');
   }
    /**
     * Esta função usa a função queHorasSerao() da classe Model para calcular que horas serão 
     * quando aterrar 
     * 
     */
   public void queHorasSerao(){
        if(Configs.formatDate.equals("Common")){
            System.out.println("Insira a data de partida de acordo com a resolução escolhida no ficheiro de configuração (dd-mm-yyyy) :");
        }
        else{
            System.out.println("Insira a data de partida de acordo com a resolução escolhida no ficheiro de configuração (yyyy-mm-dd) :");
        }
        LocalDate data = Input.lerData();
        System.out.println("Insira hora de partida no formato HH:MM :");
        LocalTime hora = Input.lerHora();
        System.out.println("Insira zona de partida :");
        String zonaP= Input.lerStringZona();
        System.out.println("Insira zona de chegada :");
        String zonaC= Input.lerStringZona();
        System.out.println("Insira a duração da viagem  no formato HH:MM :");
        LocalTime horaV = Input.lerHora();
        ZonedDateTime x =model.queHorasSerao(LocalDateTime.of(data, hora), zonaP, zonaC, horaV);
        fashionPrint(x);
   }
    
    
    
    //Metodos Agenda
    public void adicionarMarcacao(){
        System.out.println("Insira a data de acordo com o formato escolhido");
        LocalDate diaMarcacao = Input.lerData();
        System.out.println("Marcações do dia escolhido");
        ArrayList<Appointment> appointments=(ArrayList<Appointment>) model.seeAppointments(diaMarcacao).values();
        for (Appointment a: appointments){
            System.out.println(a);
        }
        System.out.println("Insira a hora a que começa a marcação pretendida (apenas entre as 10:00 e as 20:00, a cada :00 ou :30)");
        LocalTime horaInicio = Input.lerHoraMarcacao();
        System.out.println("Insira a hora a que termina a marcação pretendida (apenas entre as 10:00 e as 20:00, a cada :00 ou :30)");
        LocalTime horaFim = Input.lerHoraMarcacao();
        System.out.println("Insira a descrição da marcação");
        String description = Input.lerString();
        if (horaInicio.getMinute()>30){
            horaInicio = LocalTime.of(horaInicio.getHour(), 30);
        } else if (horaInicio.getMinute() < 30) {
            horaInicio = LocalTime.of(horaInicio.getHour(), 0);
        }
        if (horaFim.getMinute()>30){
            horaFim = LocalTime.of(horaFim.getHour(), 30);
        } else if (horaFim.getMinute() < 30) {
            horaFim = LocalTime.of(horaFim.getHour(), 0);
        }
        if (model.verificarDisponibilidadeMarcacao(diaMarcacao, horaInicio, horaFim)){
            while (horaInicio != horaFim){
                LocalTime newHoraInicio = horaFim.minusMinutes(30);
                model.makeAppointment(diaMarcacao, newHoraInicio, description);
                horaFim = newHoraInicio;
            }
        }
    }
    
    public void eliminarMarcacao(){
        System.out.println("Insira a data de acordo com o formato escolhido");
        LocalDate diaMarcacao = Input.lerData();
        System.out.println("Marcações do dia escolhido");
        ArrayList<Appointment> appointments=(ArrayList<Appointment>) model.seeAppointments(diaMarcacao).values();
        for (Appointment a: appointments){
            System.out.println(a);
        }
        System.out.println("Insira a hora a que começa a marcação pretendida (apenas entre as 10:00 e as 20:00, a cada :00 ou :30)");
        LocalTime horaInicio = Input.lerHoraMarcacao();
        if (horaInicio.getMinute()>30){
            horaInicio = LocalTime.of(horaInicio.getHour(), 30);
        } else if (horaInicio.getMinute() < 30) {
            horaInicio = LocalTime.of(horaInicio.getHour(), 0);
        }
        model.deleteApppointment(diaMarcacao, horaInicio);
    }
    
    public void verMarcacoes(){
        System.out.println("Insira a data de acordo com o formato escolhido");
        LocalDate diaMarcacao = Input.lerData();
        System.out.println("Marcações do dia escolhido");
        ArrayList<Appointment> appointments=(ArrayList<Appointment>) model.seeAppointments(diaMarcacao).values();
        for (Appointment a: appointments){
            System.out.println(a);
        }
    }
    
    //-----------------------------Flows-----------------------------------------------------
    
    //Flow principal
   
    /**
     * Esta função delinha o flow inicial da aplicação
     */
     public void startFlow () {
        Menu menu=all.getMenu(1);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "C" : calcFlow(); break;
                case "F" : fusoFlow(); break;
                case "A" : agendaFlow();break;
                case "S": break;
                default: System.out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));    
   } 
     
    //Flows Calc
     
     /**
     * Esta função delinha o flow inicial do modelo Calc ( modelo da calculadora universal)
     */
     public void calcFlow () {
        Menu menu=all.getMenu(10);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "D": datas();break;
                case "H": horas();break;
                case "E": datasHoras();break;
                case "A": adicionarDatas();break;
                case "B": subtrairDatas(); break;
                case "S": break;
                default: System.out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));    
   }
     
     
    //Flows Fuso Horario
     
     /**
     * Esta função delinha o flow inicial do modelo fuso Horário
     */
     
     public void fusoFlow () {
        Menu menu=all.getMenu(20);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "Z": horasPais();break;
                case "D": diferençaHoras();break;
                case "Q": queHorasSerao();break;
                case "V": duracaoVoo();break;
                case "S": break;
                default: System.out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));    
   }
   
        
     
     
    //Flows Agenda
     
     /**
     * Esta função delinha o flow inicial do modelo Agenda
     */
     
     public void agendaFlow () {
        Menu menu=all.getMenu(30);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "F": adicionarMarcacao(); break;
                case "V": verMarcacoes();break;
                case "E": eliminarMarcacao();break;
                case "S": break;
                default: System.out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));    
   }

}
