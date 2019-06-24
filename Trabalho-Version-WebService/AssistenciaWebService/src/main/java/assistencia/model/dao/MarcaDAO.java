/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.dao;

import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.Marca;
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
public class MarcaDAO {

    private Connection connection = DatabaseFactory.getDatabase("postgresql").conectar();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Marca marca) {
        String sql = "INSERT INTO marca(nome) VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca.getNome());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Marca marca) {
        String sql = "UPDATE marca SET nome=? WHERE cdMarca=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca.getNome());
            stmt.setInt(2, marca.getCdMarca());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Marca marca) {
        String sql = "DELETE FROM marca WHERE cdMarca=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, marca.getCdMarca());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Marca> listar() {
        String sql = "SELECT * FROM marca";
        List<Marca> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Marca marca = new Marca();
                marca.setCdMarca(resultado.getInt("cdMarca"));
                marca.setNome(resultado.getString("nome"));
                retorno.add(marca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Marca buscar(Marca marca) {
        String sql = "SELECT * FROM marca WHERE cdMarca=?";
        Marca retorno = new Marca();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, marca.getCdMarca());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                marca.setNome(resultado.getString("nome"));
                retorno = marca;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
