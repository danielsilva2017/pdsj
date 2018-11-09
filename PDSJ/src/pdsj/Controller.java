/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.Month;
import java.time.ZoneId;
import static pdsj.App.formatDate;
import static pdsj.OtherFunctions.parseDate;
import static pdsj.OtherFunctions.getMonth;
import static pdsj.OtherFunctions.parseHours;

/**
 *
 * @author silva
 */
public class Controller {
    private Model model;
    private View viewTxt;
    private Menus all = new Menus();
    
    public void setModel(Model alunos) { 
		model = alunos; 
    }
    public void setView(View txtMenus) { 
                viewTxt = txtMenus;
                all=txtMenus.initView();
    }
     //-----------------------------Metodos-----------------------------------------------------
    
    //Metodos Calc
    
    
    
    
    //Metodos Fuso Horario
    
    public void horasPais(){
       System.out.println("Qual é o id do Pais ");
       String zona= Input.lerStringZona();
       model.horasPais(zona);
   }    
   public void diferençaHoras(){
      System.out.println("Qual é o id do Pais 1 ");
       String zona= Input.lerStringZona();
       System.out.println("Qual é o id do Pais 2 ");
       String zona2= Input.lerStringZona();
       model.diferençaHoras(zona,zona2);
   }
   public void queHorasSerao(){
       int year =0;
       Month month = Month.JANUARY;
       int day =0;
        System.out.println("Insira a data de acordo com a resolução escolhida no ficheiro de configuração");
        String data= Input.lerString();
        String [] date=parseDate(data);
        if(formatDate=="Common"){
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
        System.out.println(day+"-"+month+"-"+year);
        System.out.println("Insira hora de partida no formato HH:MM");
        String horaString= Input.lerString();
        String [] horaStringRes= parseHours(horaString);
        int hora= Integer.parseInt(horaStringRes[0]);
        int minutos=Integer.parseInt(horaStringRes[1]);
        System.out.println("Insira zona de partida");
        String zonaP= Input.lerStringZona();
        System.out.println("Insira zona de chegada");
        String zonaC= Input.lerStringZona();
        System.out.println("Insira a duração da viagem  no formato HH:MM");
        String horaVString= Input.lerString();
        String [] horaVStringRes= parseHours(horaVString);
        int horaV= Integer.parseInt(horaVStringRes[0]);
        int minutosV= Integer.parseInt(horaVStringRes[1]);
        System.out.println(year+""+ ""+month+ day+ hora+minutos+zonaP+zonaC+horaV+minutosV);
        
        model.queHorasSerao(year, month, day, hora, minutos, zonaP, zonaC, horaV, minutosV);
   }
    
    
    
    //Metodos Agenda
    
    
    
    
    //-----------------------------Flows-----------------------------------------------------
    
    //Flow principal
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
     
     public void calcFlow () {
        Menu menu=all.getMenu(1);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "S": break;
                default: System.out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));    
   }
     
     
    //Flows Fuso Horario
     
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
     
     public void agendaFlow () {
        Menu menu=all.getMenu(1);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "S": break;
                default: System.out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));    
   }
}
