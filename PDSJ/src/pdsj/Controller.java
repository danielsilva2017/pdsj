/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

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
