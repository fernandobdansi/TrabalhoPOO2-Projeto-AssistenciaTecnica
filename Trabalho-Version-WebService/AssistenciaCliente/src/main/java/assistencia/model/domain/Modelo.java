/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.domain;

/**
 *
 * @author Fernando
 */
public class Modelo {

    private int cdModelo;
    private String nome;
    private Marca marca;

    public int getCdModelo() {
        return cdModelo;
    }

    public void setCdModelo(int cdModelo) {
        this.cdModelo = cdModelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo() {
    }

    public Modelo(int cdModelo, String nome, Marca marca) {
        this.cdModelo = cdModelo;
        this.nome = nome;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
