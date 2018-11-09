/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import pdsj.Menu;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Clsse que adiciona cada menu p.e "Menu Principal"
 */
public class Menus {
    public Map<Integer,Menu> mapa;
    public Menus(){
        mapa=new HashMap<>();
    }
    /**
     * Adiciona um menu ao Mapa e a sua localização no mapa
     * @param i posição no mapa
     * @param exemplo menu
     */
    public void addMenu(int i,Menu exemplo){
        mapa.put(i,exemplo);
    }
    /**
     * 
     * @return  o mapa inteiro
     */
    public Map<Integer, Menu> getMapa() {
        return mapa;
    }
    /**
     * Faz set ao mapa
     * @param mapa dos menus
     */
    public void setMapa(Map<Integer, Menu> mapa) {
        this.mapa = mapa;
    }
    /**
     * @return  devolve o valor do mapa na chave i
     * @param i posição no mapa
     */
    public Menu getMenu(int i){
        return mapa.get(i);
    }
}
