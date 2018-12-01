/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import static java.lang.System.out;
import static java.lang.System.in;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {

    /**
     * Métodos de Classe
     */
    /**
     * @return String se bem formulada
     */
    public static String lerString() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        String txt = "";
        while (!ok) {
            try {
                txt = input.nextLine();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Texto Invalido");
                out.print("Novo valor: ");
            }
        }
        return txt;
    }

    /**
     * @return String se bem formulada
     */
    public static String lerStringZona() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        String txt = "";
        while (!ok) {
            try {
                txt = input.nextLine();
                ZoneId zone = ZoneId.of(txt);
                ok = true;
            } catch (DateTimeException e) {
                out.println("Zona Invalida \n" + "Novo valor:");
            }
        }
        return txt;
    }

    /**
     * @return int se bem formulado
     */
    public static int lerInt() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        int i = 0;
        while (!ok) {
            try {
                i = input.nextInt();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Inteiro Invalido");
                out.print("Novo valor: ");
                input.nextLine();
            }
        }
        return i;
    }

    /**
     * @return double se bem formulado
     */
    public static double lerDouble() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        double d = 0.0;
        while (!ok) {
            try {
                d = input.nextDouble();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Valor real Invalido");
                out.print("Novo valor: ");
            }
        }
        return d;
    }
    /**
     * @return float se bem formulado
     */
    public static float lerFloat() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        float f = 0.0f;
        while (!ok) {
            try {
                f = input.nextFloat();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Valor real Invalido");
                out.print("Novo valor: ");

            }
        }
        return f;
    }
    /**
     * @return boolean se bem formulado
     */
    public static boolean lerBoolean() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        boolean b = false;
        while (!ok) {
            try {
                b = input.nextBoolean();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Booleano Invalido");
                out.print("Novo valor: ");
            }
        }
        return b;
    }
    /**
     * @return short se bem formulado
     */
    public static short lerShort() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        short s = 0;
        while (!ok) {
            try {
                s = input.nextShort();
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Short Invalido");
                out.print("Novo valor: ");
            }
        }
        return s;
    }
    /**
     * @return LocalDate se bem formulada
     */
    public static LocalDate lerData() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        String s = "";
        LocalDate data = LocalDate.MIN;
        while (!ok) {
            try {
                s = input.nextLine();
                if (Configs.formatDate.equals("common")) {
                	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                	data = LocalDate.parse(s, format);
                } else {
                	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                	data = LocalDate.parse(s, format);
                }
                ok = true;
            } 
            catch(InputMismatchException | DateTimeParseException e){
               out.println("Data invalida"); 
               out.print("Novo valor: ");
            }
        }
        return data;
    }
    /**
     * @return LocalTime se bem formulado
     */
    public static LocalTime lerHora() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        String s = "";
        LocalTime curr = LocalTime.MIDNIGHT;
        while (!ok) {
            try {
                s = input.nextLine();
                curr = LocalTime.parse(s);
                ok = true;

            } catch (InputMismatchException | DateTimeParseException e) {
                out.println("Hora invalida");
                out.print("Novo valor: ");
            }
        }
        return curr;
    }
    /**
     * @return LocalTime se bem formulado
     */
    public static LocalTime lerHoraMarcacao() {
        LocalTime curr = lerHora();
        while (curr.isBefore(LocalTime.of(Configs.startingHour, 00)) || curr.isAfter(LocalTime.of(Configs.endHour, 00))) {
            out.println("Hora inválida. Apenas entre as 10:00 e as 20:00");
            out.println("Novo valor: ");
            curr = lerHora();
        }
        return curr;
    }
    /**
     * @return int se bem formulado
     */
    public static int lerMes() {
        Scanner input = new Scanner(in);
        int i = 0;
        boolean ok = false;
        while (!ok) {
            try {
                i = input.nextInt();
                if (!(i > 0 && i < 13)) {
                    throw new InputMismatchException();
                }
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Mês invalido");
                out.print("Novo valor: ");
                input.nextLine();
            }
        }
        return i;
    }
    /**
     * @return int se bem formuladi
     */
    public static int lerSemana() {
        Scanner input = new Scanner(in);
        int i = 0;
        boolean ok = false;
        while (!ok) {
            try {
                i = input.nextInt();
                if (!(i > 0 && i < 5)) {
                    throw new InputMismatchException();
                }
                ok = true;
            } catch (InputMismatchException e) {
                out.println("Semana invalida");
                out.print("Novo valor: ");
                input.nextLine();
            }
        }
        return i;
    }

}
