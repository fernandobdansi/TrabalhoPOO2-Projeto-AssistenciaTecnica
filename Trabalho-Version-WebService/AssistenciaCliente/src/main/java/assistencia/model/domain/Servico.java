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
public class Servico {

    private int cdServico;
    private String descricao;

    public Servico() {
    }

    public Servico(int cdServico, String descricao) {
        this.cdServico = cdServico;
        this.descricao = descricao;
    }

    public int getCdServico() {
        return cdServico;
    }

    public void setCdServico(int cdServico) {
        this.cdServico = cdServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
