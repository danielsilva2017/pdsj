/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.util.List;


/**
 *
 * Classe que delinha o menu 
 */
public class Menu {
    private List<Opcao> lista;
    private String texto;
    /**
     * @return a lista das opçoes
     */
    public List<Opcao> getLista() {
        return lista;
    }
    /**
     * Faz set à lista
     * @param lista lista de opções
     */
    public void setLista(List<Opcao> lista) {
        this.lista = lista;
    }
    /**
     * @return o texto
     */
    public String getTexto() {
        return texto;
    }
    /**
     * Faz set ao texto
     * @param texto titulo
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
    /**
     * Contrutor do Menu
     * @param lista é a lista de opções do menu
     * @param texto é o titulo desse menu
     */
    public Menu(List<Opcao>lista, String texto) {
        this.lista=lista;
        this.texto=texto;
    }
    /**
     * Faz print do menu 
     */
    public void show() {
        System.out.println("----------------------------------------");
        System.out.println(texto);
        System.out.println("----------------------------------------");
        for(Opcao x : lista){
            System.out.println(x);
        }
    }
}
