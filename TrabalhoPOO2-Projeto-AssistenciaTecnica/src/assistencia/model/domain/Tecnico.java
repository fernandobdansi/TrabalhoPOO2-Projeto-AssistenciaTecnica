package assistencia.model.domain;

import java.io.Serializable;

public class Tecnico implements Serializable {

    private int cdTecnico;
    private String nome;
    private String cpf;
    private String telefone;

    public Tecnico(){
    }
    
    public Tecnico(int cdTecnico, String nome, String cpf) {
        this.cdTecnico = cdTecnico;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getcdTecnico() {
        return cdTecnico;
    }

    public void setcdTecnico(int cdTecnico) {
        this.cdTecnico = cdTecnico;
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
