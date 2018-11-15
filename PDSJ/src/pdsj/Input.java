/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;
import static java.lang.System.out;
import static java.lang.System.in;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.time.zone.ZoneRulesException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {

 /**
  * Métodos de Classe
  */
  /**
  * @return string se bem formulada
  */
 public static String lerString() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     String txt = "";
     while(!ok) {
         try {
             txt = input.nextLine();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Texto Invalido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     //input.close();
     return txt;
  } 
  public static String lerStringZona() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     String txt = "";
     while(!ok) {
         try {
             txt = input.nextLine();
             
             ZoneId zone= ZoneId.of(txt);
             
             
             ok = true;
         }
         catch(ZoneRulesException e) 
             { out.println("Zona Invalida"); 
               out.println("Novo valor: ");
               input.nextLine(); 
             }
     }
     //input.close();
     return txt;
  } 
 
 public static int lerInt() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     int i = 0; 
     while(!ok) {
         try {
             i = input.nextInt();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Inteiro Invalido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     //input.close();
     return i;
  } 
  
  public static double lerDouble() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     double d = 0.0; 
     while(!ok) {
         try {
             d = input.nextDouble();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Valor real Invalido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     //input.close();
     return d;
  }  
  
   public static float lerFloat() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     float f = 0.0f; 
     while(!ok) {
         try {
             f = input.nextFloat();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Valor real Invalido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     //input.close();
     return f;
  }  
  
   public static boolean lerBoolean() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     boolean b = false; 
     while(!ok) {
         try {
             b = input.nextBoolean();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Booleano Invalido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     //input.close();
     return b;
  } 
  
  public static short lerShort() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     short s = 0; 
     while(!ok) {
         try {
             s = input.nextShort();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Short Invalido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     //input.close();
     return s;
  }
  
  public static String lerData(){
      Scanner input = new Scanner(in);
      boolean ok = false;
      String s = "";
      while(!ok){
            try {
                s = input.nextLine();
                LocalDate.parse(s);
                ok = true;
            } 
            catch(InputMismatchException | DateTimeParseException e){
               out.println("Data invalida"); 
               out.print("Novo valor: ");
               input.nextLine(); 
            }
      }
      return s;
  }
  
  public static String lerHora(){
      Scanner input = new Scanner(in);
      boolean ok = false;
      String s = "";
      while(!ok){
            try {
                s = input.nextLine();
                LocalTime curr = LocalTime.parse(s);
                if (!(curr.isBefore(LocalTime.of(Configs.startingHour, 00)) || curr.isAfter(LocalTime.of(Configs.endHour, 00)))) ok = true;
            } 
            catch(InputMismatchException | DateTimeParseException e){
               out.println("Hora invalida"); 
               out.print("Novo valor: ");
               input.nextLine(); 
            }
      }
      return s;
  }
  
}