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
        Opcao op1, op2, op3, op4,op5;  
        
        //Menu principal
        op1 = new Opcao("Calculadora de datas ", "C");
        op2 = new Opcao("Fuso Horarios", "F");
        op3 = new Opcao("Agenda ", "A"); 
        List<Opcao> linhas = Arrays.asList(op1, op2, op3);
        Menu menuAlunos = new Menu(linhas, "   Menu principal");        
        menusSIGCA.addMenu(1, menuAlunos);
        
        
        //Calculadora
        List<Opcao> linhas2 = Arrays.asList(op1, op2, op3);
        Menu menuAlunos2 = new Menu(linhas2, "   Menu principal");        
        menusSIGCA.addMenu(2, menuAlunos2);
       
        
        
        
        
        //Fuso horario
        op1 = new Opcao("Zona Globo ", "Z");
        op2 = new Opcao("Diferença de horas", "D");
        op3 = new Opcao("Que horas serao? ", "Q"); 
        List<Opcao> linhas20 = Arrays.asList(op1, op2, op3);
        Menu menuAlunos20 = new Menu(linhas20, "   Menu principal do Fuso");        
        menusSIGCA.addMenu(20, menuAlunos20);
        
        
        //Agenda
        op1 = new Opcao("Fazer marcação ", "F");
        op2 = new Opcao("Ver marcações ", "V");
        op3 = new Opcao("Eliminar marcações ", "E"); 
        List<Opcao> linhas30 = Arrays.asList(op1, op2, op3);
        Menu menu30 = new Menu(linhas30, "   Menu principal da Agenda");        
        menusSIGCA.addMenu(30, menu30);
        
        
        
        
        
        
        
        
        
        
         return menusSIGCA;
     }
}
