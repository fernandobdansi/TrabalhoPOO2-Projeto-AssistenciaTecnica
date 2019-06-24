/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.dao;

import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.Cliente;
import assistencia.model.domain.Dispositivo;
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
public class DispositivoDAO {

    private Connection connection =  DatabaseFactory.getDatabase("postgresql").conectar();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Dispositivo dispositivo) {
        String sql = "INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES(?,?,?,?,?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, dispositivo.getNumSerie());
            stmt.setString(2, dispositivo.getDescricao());
            stmt.setInt(3, dispositivo.getModelo().getCdModelo());
            stmt.setInt(4, dispositivo.getMarca().getCdMarca());
            stmt.setInt(5, dispositivo.getCliente().getCdCliente());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Dispositivo dispositivo) {
        String sql = "UPDATE dispositivo SET numSerie=?, descricao=?, cdModelo=?, cdMarca=?, cdCliente=? WHERE cdDispositivo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, dispositivo.getNumSerie());
            stmt.setString(2, dispositivo.getDescricao());
            stmt.setInt(3, dispositivo.getModelo().getCdModelo());
            stmt.setInt(4, dispositivo.getMarca().getCdMarca());
            stmt.setInt(5, dispositivo.getCliente().getCdCliente());
            stmt.setInt(6, dispositivo.getCdDispositivo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Dispositivo dispositivo) {
        String sql = "DELETE FROM dispositivo WHERE cdDispositivo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dispositivo.getCdDispositivo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Dispositivo> listar() {
        String sql = "SELECT cddispositivo, numserie, descricao, cdmodelo, cdmarca, cdcliente FROM dispositivo";
        List<Dispositivo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Dispositivo dispositivo = new Dispositivo();
                Cliente cliente = new Cliente();
                Marca marca = new Marca();
                Modelo modelo = new Modelo();

                dispositivo.setCdDispositivo(resultado.getInt("cdDispositivo"));
                dispositivo.setDescricao(resultado.getString("descricao"));
                dispositivo.setNumSerie(resultado.getString("numSerie"));
                cliente.setCdCliente(resultado.getInt("cdCliente"));
                marca.setCdMarca(resultado.getInt("cdMarca"));
                modelo.setCdModelo(resultado.getInt("cdModelo"));

                //Obtendo os dados completos do Cliente associado à Dispositivo
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.setConnection(connection);
                cliente = clienteDAO.buscar(cliente);

                //Obtendo os dados completos do Marca associado à Dispositivo
                MarcaDAO marcaDAO = new MarcaDAO();
                marcaDAO.setConnection(connection);
                marca = marcaDAO.buscar(marca);

                //Obtendo os dados completos do Modelo associado à Dispositivo
                ModeloDAO modeloDAO = new ModeloDAO();
                modeloDAO.setConnection(connection);
                modelo = modeloDAO.buscar(modelo);

                dispositivo.setCliente(cliente);
                dispositivo.setMarca(marca);
                dispositivo.setModelo(modelo);

                retorno.add(dispositivo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Dispositivo> listarPorCliente(Cliente cliente) {
        String sql = "SELECT * FROM dispositivo WHERE cdCliente=?";
        List<Dispositivo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getCdCliente());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Dispositivo dispositivo = new Dispositivo();
                Marca marca = new Marca();
                Modelo modelo = new Modelo();

                dispositivo.setCdDispositivo(resultado.getInt("cdDispositivo"));
                dispositivo.setDescricao(resultado.getString("descricao"));
                dispositivo.setNumSerie(resultado.getString("numSerie"));
                cliente.setCdCliente(resultado.getInt("cdCliente"));
                marca.setCdMarca(resultado.getInt("cdMarca"));
                modelo.setCdModelo(resultado.getInt("cdModelo"));

                //Obtendo os dados completos do Cliente associado à Dispositivo


                //Obtendo os dados completos do Marca associado à Dispositivo
                MarcaDAO marcaDAO = new MarcaDAO();
                marcaDAO.setConnection(connection);
                marca = marcaDAO.buscar(marca);

                //Obtendo os dados completos do Modelo associado à Dispositivo
                ModeloDAO modeloDAO = new ModeloDAO();
                modeloDAO.setConnection(connection);
                modelo = modeloDAO.buscar(modelo);

                dispositivo.setCliente(cliente);
                dispositivo.setMarca(marca);
                dispositivo.setModelo(modelo);

                retorno.add(dispositivo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Dispositivo buscar(Dispositivo dispositivo) {
        String sql = "SELECT * FROM dispositivo WHERE cdDispositivo=?";
        Dispositivo retorno = new Dispositivo();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dispositivo.getCdDispositivo());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                Cliente cliente = new Cliente();
                Marca marca = new Marca();
                Modelo modelo = new Modelo();

                dispositivo.setCdDispositivo(resultado.getInt("cdDispositivo"));
                dispositivo.setDescricao(resultado.getString("descricao"));
                dispositivo.setNumSerie(resultado.getString("numSerie"));
                cliente.setCdCliente(resultado.getInt("cdCliente"));
                marca.setCdMarca(resultado.getInt("cdMarca"));
                modelo.setCdModelo(resultado.getInt("cdModelo"));

                dispositivo.setCliente(cliente);
                dispositivo.setMarca(marca);
                dispositivo.setModelo(modelo);
                retorno = dispositivo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
