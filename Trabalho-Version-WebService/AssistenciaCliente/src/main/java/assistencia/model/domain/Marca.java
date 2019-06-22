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
public class Marca {

    private int cdMarca;
    private String nome;

    public Marca() {
        
    }

    public int getCdMarca() {
        return cdMarca;
    }

    public void setCdMarca(int cdMarca) {
        this.cdMarca = cdMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca(int cdMarca, String nome) {
        this.cdMarca = cdMarca;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
