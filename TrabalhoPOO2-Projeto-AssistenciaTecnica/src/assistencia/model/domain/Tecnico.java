package assistencia.model.domain;

import java.io.Serializable;
import java.text.NumberFormat;

public class Tecnico implements Serializable {

    private int cdTecnico;
    private String nome;
    private String cpf;
    private String telefone;
    private float valorTotalServico;
    private String valorFormatado;

    public Tecnico() {
    }

    public Tecnico(int cdTecnico, String nome, String cpf) {
        this.cdTecnico = cdTecnico;
        this.nome = nome;
        this.cpf = cpf;
    }

    public float getValorTotalServico() {
        return valorTotalServico;
    }

    public void setValorTotalServico(float valorTotalServico) {
        this.valorTotalServico = valorTotalServico;
    }

    public int getCdTecnico() {
        return cdTecnico;
    }

    public void setCdTecnico(int cdTecnico) {
        this.cdTecnico = cdTecnico;
    }

    public String getValorFormatado() {
        valorFormatado = NumberFormat.getCurrencyInstance().format(valorTotalServico);
        return valorFormatado;
    }

    public void setValorFormatado(String valorFormatado) {
        this.valorFormatado = String.valueOf(valorTotalServico);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
