/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author Sephthia Winter
 */
public class App {
    public  static  String formatDate="Common";    
    public static void readFile()throws IOException{
        String fileName = "C:\\Users\\silva\\Desktop\\mei\\pdsj\\trabalho\\pdsj\\conf.txt";
        FileReader fileReader = new FileReader(fileName);
        String [] lines = new String[10];

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            int i =0;
            while((line = bufferedReader.readLine()) != null) {
                i++;
                lines[i] = line;
            }
             
        }
        formatDate=lines[1];
    }
    public static void main(String[] args) throws IOException {    
        // Modelo MVC
        readFile();
        Model model = new Model();
        View view = new View();
        Controller control =new Controller();
        control.setModel(model);  
        control.setView(view);
        control.startFlow();
        //--------------------------------
        out.println("Fim da Aplicação >> "
                         + java.time.LocalDateTime.now());
        System.exit(0);
    }   
 }
