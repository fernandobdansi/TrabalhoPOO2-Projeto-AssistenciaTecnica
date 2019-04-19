/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.domain;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class OrdemDeServico {

    private Cliente cliente;
    private Dispositivo dispositivo;
    private List<ItemServicoOrdem> itemServicoOrdem;
    private Tecnico tecnico;
    private Status status;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String descricaoProblema;
    private double valorTotal;

    public OrdemDeServico() {
    }

    public OrdemDeServico(Cliente cliente, Dispositivo dispositivo, List<ItemServicoOrdem> itemServicoOrdem, Tecnico tecnico, Status status, LocalDate dataEntrada, LocalDate dataSaida, String descricaoProblema, double valorTotal) {
        this.cliente = cliente;
        this.dispositivo = dispositivo;
        this.itemServicoOrdem = itemServicoOrdem;
        this.tecnico = tecnico;
        this.status = status;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.descricaoProblema = descricaoProblema;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public List<ItemServicoOrdem> getItemServicoOrdem() {
        return itemServicoOrdem;
    }

    public void setItemServicoOrdem(List<ItemServicoOrdem> itemServicoOrdem) {
        this.itemServicoOrdem = itemServicoOrdem;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "OrdemDeServico{" + "cliente=" + cliente + ", dispositivo=" + dispositivo + ", tecnico=" + tecnico + ", status=" + status + ", dataEntrada=" + dataEntrada + ", valorTotal=" + valorTotal + '}';
    }

}
