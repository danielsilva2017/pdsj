/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

/**
 *
 * @author silva
 */
public class Opcao {
    private String texto;
    private String etiqueta;
    public Opcao(String texto, String etiqueta) {
        this.texto=texto;
        this.etiqueta=etiqueta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return ""+  texto  +" "+ etiqueta + '}';
    }
    
}
