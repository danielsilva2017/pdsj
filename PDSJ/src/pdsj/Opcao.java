/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

/**
 *
 * A classe opção tem como objetivo criar uma opção
 */
public class Opcao {
    private String texto;
    private String etiqueta;
    /**
     * Construtor da classe
     * @param texto String da opçao p.e. "Zona Globo"
     * @param etiqueta a abreviatura dessa opçao p.e "Z"
     */
    
    public Opcao(String texto, String etiqueta) {
        this.texto=texto;
        this.etiqueta=etiqueta;
    }
    /**
     *
     * @return o texto
     */
    public String getTexto() {
        return texto;
    }
    /**
    * Faz set ao texto
    * @param texto da opçao
    */
    public void setTexto(String texto) {
        this.texto = texto;
    }
    /**
    * @return da etiqueta
    */
    public String getEtiqueta() {
        return etiqueta;
    }
    /**
    * Faz set à etiqueta
    * @param etiqueta da opçao
    */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    /**
    * @return do objeto em String
    */
    @Override
    public String toString() {
        return ""+  texto  +" "+ etiqueta + '}';
    }
    
}
