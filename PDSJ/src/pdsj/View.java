/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author silva
 */
public class View {
    public View() {
        dateApiMenus= initView();  // 
    }

    private Menus dateApiMenus = new Menus();

    // Cria a View baseada em Menus textuais
    public static Menus initView() { 
        Menus menusSIGCA = new Menus();
        Opcao op1, op2, op3, op4, op5, op6;  
        
        //Menu principal
        op1 = new Opcao("Calculadora de Datas ....... ", "C");
        op2 = new Opcao("Fuso Horarios .............. ", "F");
        op3 = new Opcao("Agenda ..................... ", "A"); 
        op4 = new Opcao("Sair da Aplicação >>>>>>>>>> ", "S");  
        List<Opcao> linhas = Arrays.asList(op1, op2, op3, op4);
        Menu menu = new Menu(linhas, "   Menu Principal");        
        menusSIGCA.addMenu(1, menu);
        
        
        //Calculadora
        op1 = new Opcao("Diferença Entre Datas ........... ", "D");
        op2 = new Opcao("Diferença Entre Horas ........... ", "H");
        op3 = new Opcao("Diferença Entre Datas e Horas ... ", "E");
        op4 = new Opcao("Adicionar Valores a uma Data .... ", "A"); 
        op5 = new Opcao("Subtrair Valores a uma Data ..... ", "B"); 
        op6 = new Opcao("Menu Principal >>>>>>>>>>>>>>>>>> ", "S"); 
        List<Opcao> linhas10 = Arrays.asList(op1, op2, op3, op4, op5, op6);
        Menu menu10 = new Menu(linhas10, "   Menu principal da Calculadora");        
        menusSIGCA.addMenu(10, menu10);
       
        
        
        
        
        //Fuso horario
        op1 = new Opcao("Zona Globo ........... ", "Z");
        op2 = new Opcao("Diferença de Horas ... ", "D");
        op3 = new Opcao("Que horas serao? ..... ", "Q"); 
        op4 = new Opcao("Duracao de Voo........ ", "V");
        op5 = new Opcao("Menu Principal >>>>>>> ", "S"); 
        List<Opcao> linhas20 = Arrays.asList(op1, op2, op3, op4,op5);
        Menu menuAlunos20 = new Menu(linhas20, "   Menu principal do Fuso");        
        menusSIGCA.addMenu(20, menuAlunos20);
        
        
        //Agenda
        op1 = new Opcao("Fazer Marcação ....... ", "F");
        op2 = new Opcao("Ver Marcações ........ ", "V");
        op3 = new Opcao("Eliminar Marcações ... ", "E"); 
        op4 = new Opcao("Menu Principal >>>>>>> ", "S"); 
        List<Opcao> linhas30 = Arrays.asList(op1, op2, op3, op4);
        Menu menu30 = new Menu(linhas30, "   Menu principal da Agenda");        
        menusSIGCA.addMenu(30, menu30);

        
         return menusSIGCA;
     }
}
