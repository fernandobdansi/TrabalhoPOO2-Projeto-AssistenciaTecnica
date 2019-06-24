/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.dao;

import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.Status;
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
public class StatusDAO {

    private Connection connection =  DatabaseFactory.getDatabase("postgresql").conectar();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Status status) {
        String sql = "INSERT INTO status(descricao) VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, status.getDescricao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Status status) {
        String sql = "UPDATE status SET descricao=? WHERE cdStatus=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, status.getDescricao());
            stmt.setInt(2, status.getCdStatus());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Status status) {
        String sql = "DELETE FROM status WHERE cdStatus=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, status.getCdStatus());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Status> listar() {
        String sql = "SELECT * FROM status";
        List<Status> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Status status = new Status();
                status.setCdStatus(resultado.getInt("cdStatus"));
                status.setDescricao(resultado.getString("descricao"));
                retorno.add(status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Status buscar(Status status) {
        String sql = "SELECT * FROM status WHERE cdStatus=?";
        Status retorno = new Status();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, status.getCdStatus());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                status.setDescricao(resultado.getString("descricao"));
                retorno = status;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
