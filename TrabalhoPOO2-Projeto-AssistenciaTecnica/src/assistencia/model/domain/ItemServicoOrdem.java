package assistencia.model.domain;

import java.io.Serializable;
import java.text.NumberFormat;

public class ItemServicoOrdem {

    private int cdItemServicoOrdem;
    private double valor;
    private OrdemDeServico ordemDeServico;
    private Servico servico;
    private String valorFormatado;

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

    public String getValorFormatado() {
        valorFormatado = NumberFormat.getCurrencyInstance().format(valor);
        return valorFormatado;
    }

    public void setValorFormatado(String valorFormatado) {
        this.valorFormatado = String.valueOf(valor);
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
