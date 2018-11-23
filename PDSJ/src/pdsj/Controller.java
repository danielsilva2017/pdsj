/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import static pdsj.OtherFunctions.parseDate;
import static pdsj.OtherFunctions.getMonth;
import static pdsj.OtherFunctions.parseHours;

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
        LocalDate data1 = LocalDate.parse(Input.lerData());
        System.out.println("Insira a data final: ");
        LocalDate data2 = LocalDate.parse(Input.lerData());
        model.contasDatas(data1,data2);
    }
    /*
    * Esta função usa contasHoras da classe Model para calcular a diferença 
    * duas horas
    */
    public void horas(){
        System.out.println("Insira a hora inicial: ");
        LocalTime hora1 = LocalTime.parse(Input.lerHora());
        System.out.println("Insira a hora final: ");
        LocalTime hora2 = LocalTime.parse(Input.lerHora());
        model.contasHoras(hora1,hora2);
    }
    /*
    * Esta função usa contasDatasHoras da classe Model para calcular a diferença 
    * duas datas e horas
    */
    public void datasHoras(){
        if(Configs.formatDate.equals("Common")){
            System.out.println("Formato data: dd-mm-yyyy");
        }
        else{
            System.out.println("Formato data: yyyy-mm-dd");
        }
        System.out.println("Insira a data inicial: ");
        LocalDate data1 = LocalDate.parse(Input.lerData());
        System.out.println("Insira a hora inicial: ");
        LocalTime hora1 = LocalTime.parse(Input.lerHora());
        
        System.out.println("Insira a data final: ");
        LocalDate data2 = LocalDate.parse(Input.lerData());
        System.out.println("Insira a hora final: ");
        LocalTime hora2 = LocalTime.parse(Input.lerHora());
        model.contasDatasHoras(data1, data2, hora1, hora2);
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
        LocalDate data = LocalDate.parse(Input.lerData());
        System.out.println("Insira valores a adicionar: ");
        System.out.println("  Anos: ");
        int ano = Input.lerInt();
        System.out.println("  Meses: ");
        int mes = Input.lerInt();
        System.out.println("  Semanas: ");
        int semana = Input.lerInt();
        System.out.println("  Dias: ");
        int dias = Input.lerInt();
        model.addDatas(data, ano, mes, semana, dias);
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
        LocalDate data = LocalDate.parse(Input.lerData());
        System.out.println("Insira valores a adicionar: ");
        System.out.println("  Anos: ");
        int ano = Input.lerInt();
        System.out.println("  Meses: ");
        int mes = Input.lerInt();
        System.out.println("  Semanas: ");
        int semana = Input.lerInt();
        System.out.println("  Dias: ");
        int dias = Input.lerInt();
        model.subDatas(data, ano, mes, semana, dias);
    }
    
    
    //Metodos Fuso Horario
    /**
     * Esta função usa a função horasPais() da classe Model para calcular uma hora num determinado
     * país
     */
    public void horasPais(){
       System.out.println("Qual é o id do Pais? ");
       String zona= Input.lerStringZona();
       model.horasPais(zona);
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
       model.diferençaHoras(zona,zona2);
   }
    /**
     * Esta função usa a função queHorasSerao() da classe Model para calcular que horas serão 
     * quando aterrar 
     * 
     */
   public void queHorasSerao(){
       int year =0;
       Month month = Month.JANUARY;
       int day =0;
        System.out.println("Insira a data de acordo com a resolução escolhida no ficheiro de configuração :");
        String data= Input.lerString();
        String [] date=parseDate(data);
        if(Configs.formatDate.equals("Common")){
            day = Integer.parseInt(date[0]);
            int auxMonth= Integer.parseInt(date[1]);
            month = getMonth(auxMonth);
            year = Integer.parseInt(date[2]);
        }
        else{
            year = Integer.parseInt(date[0]);
            int auxMonth= Integer.parseInt(date[1]);
            month = getMonth(auxMonth);
            day= Integer.parseInt(date[2]);
        }
        System.out.println("Insira hora de partida no formato HH:MM :");
        String horaString= Input.lerString();
        String [] horaStringRes= parseHours(horaString);
        int hora= Integer.parseInt(horaStringRes[0]);
        int minutos=Integer.parseInt(horaStringRes[1]);
        System.out.println("Insira zona de partida :");
        String zonaP= Input.lerStringZona();
        System.out.println("Insira zona de chegada :");
        String zonaC= Input.lerStringZona();
        System.out.println("Insira a duração da viagem  no formato HH:MM :");
        String horaVString= Input.lerString();
        String [] horaVStringRes= parseHours(horaVString);
        int horaV= Integer.parseInt(horaVStringRes[0]);
        int minutosV= Integer.parseInt(horaVStringRes[1]);
        
        model.queHorasSerao(year, month, day, hora, minutos, zonaP, zonaC, horaV, minutosV);
   }
    
    
    
    //Metodos Agenda
    public void adicionarMarcacao(){
        System.out.println("Insira a data de acordo com o formato escolhido");
        LocalDate diaMarcacao = LocalDate.parse(Input.lerData());
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
        LocalDate diaMarcacao = LocalDate.parse(Input.lerData());
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
        LocalDate diaMarcacao = LocalDate.parse(Input.lerData());
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
                case "F": break;
                case "S": break;
                default: System.out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));    
   }

}
