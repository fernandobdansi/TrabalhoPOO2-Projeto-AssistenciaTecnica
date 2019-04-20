package assistencia.model.domain;

import java.io.Serializable;

public class ItemServicoOrdem implements Serializable {

    private int cdItemServicoOrdem;
    private double valor;
    private OrdemDeServico ordemDeServico;
    private Servico servico;

    public ItemServicoOrdem() {
    }

    public ItemServicoOrdem(int cdItemServicoOrdem, double valor, OrdemDeServico ordemDeServico, Servico servico) {
        this.cdItemServicoOrdem = cdItemServicoOrdem;
        this.valor = valor;
        this.ordemDeServico = ordemDeServico;
        this.servico = servico;
    }

    public int getCdItemServicoOrdem() {
        return cdItemServicoOrdem;
    }

    public void setCdItemServicoOrdem(int cdItemServicoOrdem) {
        this.cdItemServicoOrdem = cdItemServicoOrdem;
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