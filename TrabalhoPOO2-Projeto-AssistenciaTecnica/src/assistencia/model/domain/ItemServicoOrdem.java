package assistencia.model.domain;

import java.io.Serializable;

public class ItemServicoOrdem implements Serializable {

    private int cdItemDeVenda;
    private double valor;
    private OrdemDeServico ordemDeServico;
    private Servico servico;

    public ItemServicoOrdem() {
    }

    public ItemServicoOrdem(int cdItemDeVenda, double valor, OrdemDeServico ordemDeServico, Servico servico) {
        this.cdItemDeVenda = cdItemDeVenda;
        this.valor = valor;
        this.ordemDeServico = ordemDeServico;
        this.servico = servico;
    }

    public int getCdItemDeVenda() {
        return cdItemDeVenda;
    }

    public void setCdItemDeVenda(int cdItemDeVenda) {
        this.cdItemDeVenda = cdItemDeVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "ItemServicoOrdem{" + "valor=" + valor + ", servico=" + servico + '}';
    }

}
