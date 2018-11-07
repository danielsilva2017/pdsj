/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.util.List;


/**
 *
 * @author silva
 */
public class Menu {
    private List<Opcao> lista;
    private String texto;

    public List<Opcao> getLista() {
        return lista;
    }

    public void setLista(List<Opcao> lista) {
        this.lista = lista;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Menu(List<Opcao>lista, String texto) {
        this.lista=lista;
        this.texto=texto;
    }

    public void show() {
        System.out.println("----------------------------------------");
        System.out.println(texto);
        System.out.println("----------------------------------------");
        for(Opcao x : lista){
            System.out.println(x);
        }
    }
}
