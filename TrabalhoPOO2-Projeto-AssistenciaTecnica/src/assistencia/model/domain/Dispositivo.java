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
public class Dispositivo {

    private int cdDispositivo;
    private String numSerie;
    private String descricao;
    private Modelo modelo;
    private Marca marca;
    private Cliente cliente;

    public Dispositivo() {
    }

    public Dispositivo(int cdDispositivo, Modelo modelo, Marca marca, String numSerie, String descricao, Cliente cliente) {
        this.cdDispositivo = cdDispositivo;
        this.modelo = modelo;
        this.marca = marca;
        this.numSerie = numSerie;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public int getCdDispositivo() {
        return cdDispositivo;
    }

    public void setCdDispositivo(int cdDispositivo) {
        this.cdDispositivo = cdDispositivo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return this.numSerie;
    }

}
