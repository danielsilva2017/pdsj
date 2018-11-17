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
* Esta é a classe Main a que inicia a aplicação
*/
public class App {
    /**
     * Esta função lê o ficheiro de configuração inicial que o utilizador modificar e inicia as 
     * configurações da aplicação de acordo com esse ficheiro de configuração
     * @throws IOException se o ficheiro de configuração não for encontrado
     */
    public static void readFile()throws IOException{
        String fileName = System.getProperty("user.dir")+"\\conf.txt";
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
        Configs.formatDate=lines[1];
    }
    
    /**
     * Esta função executa a aplicação
     * @param args not used here
     * @throws IOException se o ficheiro de configuração não for encontrado
     */
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
