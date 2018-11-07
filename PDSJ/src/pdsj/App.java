/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;
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

    
    public static void main(String[] args) {    
        // Modelo MVC
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
