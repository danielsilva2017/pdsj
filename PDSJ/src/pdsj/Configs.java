/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

public class Configs {
    public static String formatDate="Common";
    public static int startingHour = 10; //hora a que podem começar os appointments
    public static int endHour = 20; //hora a que podem terminar os appointments
    
    public void mudarFormatoData(String newFormat){
        formatDate=newFormat;
    }
    
    public void mudarHoraComecoMarcacao(int newHour){
        startingHour=newHour;
    }
    
    public void mudarHoraFimMarcacao(int newHour){
        endHour=newHour;
    }
    
}
