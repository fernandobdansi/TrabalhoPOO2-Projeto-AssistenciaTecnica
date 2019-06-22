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
public class Status {

    private int cdStatus;
    private String descricao;

    public Status() {
    }

    public Status(int cdStatus, String descricao) {
        this.cdStatus = cdStatus;
        this.descricao = descricao;
    }

    public int getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(int cdStatus) {
        this.cdStatus = cdStatus;
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
