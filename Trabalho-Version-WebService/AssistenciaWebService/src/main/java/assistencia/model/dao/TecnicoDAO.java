/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.dao;

import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.Tecnico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class TecnicoDAO {

    private Connection connection =  DatabaseFactory.getDatabase("postgresql").conectar();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Tecnico tecnico) {
        String sql = "INSERT INTO tecnico(nome, cpf, telefone) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getCpf());
            stmt.setString(3, tecnico.getTelefone());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Tecnico tecnico) {
        String sql = "UPDATE tecnico SET nome=?, cpf=?, telefone=? WHERE cdTecnico=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getCpf());
            stmt.setString(3, tecnico.getTelefone());
            stmt.setInt(4, tecnico.getCdTecnico());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Tecnico tecnico) {
        String sql = "DELETE FROM tecnico WHERE cdTecnico=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, tecnico.getCdTecnico());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Tecnico> listar() {
        String sql = "SELECT * FROM tecnico";
        List<Tecnico> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Tecnico tecnico = new Tecnico();
                tecnico.setCdTecnico(resultado.getInt("cdTecnico"));
                tecnico.setNome(resultado.getString("nome"));
                tecnico.setCpf(resultado.getString("cpf"));
                tecnico.setTelefone(resultado.getString("telefone"));
                retorno.add(tecnico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Tecnico buscar(Tecnico tecnico) {
        String sql = "SELECT * FROM tecnico WHERE cdTecnico=?";
        Tecnico retorno = new Tecnico();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, tecnico.getCdTecnico());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                tecnico.setNome(resultado.getString("nome"));
                tecnico.setCpf(resultado.getString("cpf"));
                tecnico.setTelefone(resultado.getString("telefone"));
                retorno = tecnico;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Tecnico> listarTecnicoPorOrdem() {
        String sql = "SELECT tecnico.*, sum(ordemdeservico.valortotal)\n"
                + "FROM tecnico, ordemdeservico\n"
                + "WHERE tecnico.cdtecnico=ordemdeservico.cdtecnico\n"
                + "GROUP BY tecnico.cdtecnico";
        List<Tecnico> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Tecnico tecnico = new Tecnico();
                tecnico.setCdTecnico(resultado.getInt("cdTecnico"));
                tecnico.setNome(resultado.getString("nome"));
                tecnico.setCpf(resultado.getString("cpf"));
                tecnico.setTelefone(resultado.getString("telefone"));
                tecnico.setValorTotalServico(resultado.getFloat("sum"));
                retorno.add(tecnico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
