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
 * @author silva
 */
public class Menus {
    public Map<Integer,Menu> mapa;
    public Menus(){
        mapa=new HashMap<>();
    }
    public void addMenu(int i,Menu exemplo){
        mapa.put(i,exemplo);
    }

    public Map<Integer, Menu> getMapa() {
        return mapa;
    }

    public void setMapa(Map<Integer, Menu> mapa) {
        this.mapa = mapa;
    }
    public Menu getMenu(int i){
        return mapa.get(i);
    }
}
