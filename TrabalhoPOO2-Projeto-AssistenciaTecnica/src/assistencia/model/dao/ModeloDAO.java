/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.dao;

import assistencia.model.domain.Marca;
import assistencia.model.domain.Modelo;
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
public class ModeloDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Modelo modelo) {
        String sql = "INSERT INTO modelo(nome, cdMarca) VALUES('?','?');";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, modelo.getNome());
            stmt.setInt(2, modelo.getMarca().getCdMarca());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Modelo modelo) {
        String sql = "UPDATE modelo SET nome=?, cdMarca=? WHERE cdModelo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, modelo.getNome());
            stmt.setInt(2, modelo.getMarca().getCdMarca());
            stmt.setInt(3, modelo.getCdModelo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Modelo modelo) {
        String sql = "DELETE FROM modelo WHERE cdModelo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modelo.getCdModelo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Modelo> listar() {
        String sql = "SELECT * FROM modelo";
        List<Modelo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Modelo modelo = new Modelo();
                Marca marca = new Marca();

                marca.setCdMarca(resultado.getInt("cdMarca"));
                modelo.setCdModelo(resultado.getInt("cdModelo"));
                modelo.setNome(resultado.getString("nome"));

                MarcaDAO marcaDAO = new MarcaDAO();
                marcaDAO.setConnection(connection);
                marca = marcaDAO.buscar(marca);

                modelo.setMarca(marca);

                retorno.add(modelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Modelo> listarModeloPorMarca(Marca marca) {
        String sql = "SELECT * FROM modelo WHERE cdMarca=?";
        List<Modelo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, marca.getCdMarca());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Modelo modelo = new Modelo();
                marca.setCdMarca(resultado.getInt("cdMarca"));
                modelo.setCdModelo(resultado.getInt("cdModelo"));
                modelo.setNome(resultado.getString("nome"));
                modelo.setMarca(marca);

                retorno.add(modelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Modelo buscar(Modelo modelo) {
        String sql = "SELECT * FROM modelo WHERE cdModelo=?";
        Modelo retorno = new Modelo();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modelo.getCdModelo());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {

                Marca marca = new Marca();

                modelo.setNome(resultado.getString("nome"));
                marca.setCdMarca(resultado.getInt("cdMarca"));

                modelo.setMarca(marca);
                retorno = modelo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
