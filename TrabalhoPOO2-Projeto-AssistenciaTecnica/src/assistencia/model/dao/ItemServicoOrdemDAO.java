/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.dao;

import assistencia.model.domain.ItemServicoOrdem;
import assistencia.model.domain.OrdemDeServico;
import assistencia.model.domain.Servico;
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
public class ItemServicoOrdemDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(ItemServicoOrdem itenservicoordem) {
        String sql = "INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('?','?','?')";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, itenservicoordem.getValor());
            stmt.setInt(2, itenservicoordem.getOrdemDeServico().getCdOrdemDeServico());
            stmt.setInt(3, itenservicoordem.getServico().getCdServico());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemServicoOrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(ItemServicoOrdem itenservicoordem) {
        String sql = "UPDATE itenservicoordem SET valor=?, cdOrdemDeServico=?, cdServico=? WHERE cdItemServicoOrdem=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, itenservicoordem.getValor());
            stmt.setInt(2, itenservicoordem.getOrdemDeServico().getCdOrdemDeServico());
            stmt.setInt(3, itenservicoordem.getServico().getCdServico());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemServicoOrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(ItemServicoOrdem itenservicoordem) {
        String sql = "DELETE FROM itenservicoordem WHERE cdItemServicoOrdem=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itenservicoordem.getCdItemServicoOrdem());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemServicoOrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<ItemServicoOrdem> listar() {
        String sql = "SELECT * FROM itenservicoordem";
        List<ItemServicoOrdem> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ItemServicoOrdem itenservicoordem = new ItemServicoOrdem();
                OrdemDeServico ordemdeservico = new OrdemDeServico();
                Servico servico = new Servico();

                ordemdeservico.setCdOrdemDeServico(resultado.getInt("cdOrdemDeServico"));
                servico.setCdServico(resultado.getInt("cdServico"));
                itenservicoordem.setCdItemServicoOrdem(resultado.getInt("cdItemServicoOrdem"));
                itenservicoordem.setValor(resultado.getDouble("valor"));

                ServicoDAO servicoDAO = new ServicoDAO();
                servicoDAO.setConnection(connection);
                servico = servicoDAO.buscar(servico);

                OrdemDeServicoDAO ordemdeservicoDAO = new OrdemDeServicoDAO();
                ordemdeservicoDAO.setConnection(connection);
                ordemdeservico = ordemdeservicoDAO.buscar(ordemdeservico);

                itenservicoordem.setOrdemDeServico(ordemdeservico);
                itenservicoordem.setServico(servico);

                retorno.add(itenservicoordem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemServicoOrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<ItemServicoOrdem> listarPorOrdemDeServico(OrdemDeServico ordemDeServico) {
        String sql = "SELECT * FROM itenservicoordem WHERE cdOrdemDeServico=?";
        List<ItemServicoOrdem> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ordemDeServico.getCdOrdemDeServico());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ItemServicoOrdem itenservicoordem = new ItemServicoOrdem();
                OrdemDeServico ordemdeservico = new OrdemDeServico();
                Servico servico = new Servico();

                ordemdeservico.setCdOrdemDeServico(resultado.getInt("cdOrdemDeServico"));
                servico.setCdServico(resultado.getInt("cdServico"));
                itenservicoordem.setCdItemServicoOrdem(resultado.getInt("cdItemServicoOrdem"));
                itenservicoordem.setValor(resultado.getDouble("valor"));

                ServicoDAO servicoDAO = new ServicoDAO();
                servicoDAO.setConnection(connection);
                servico = servicoDAO.buscar(servico);

                OrdemDeServicoDAO ordemdeservicoDAO = new OrdemDeServicoDAO();
                ordemdeservicoDAO.setConnection(connection);
                ordemdeservico = ordemdeservicoDAO.buscar(ordemdeservico);

                itenservicoordem.setOrdemDeServico(ordemdeservico);
                itenservicoordem.setServico(servico);

                retorno.add(itenservicoordem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemServicoOrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public ItemServicoOrdem buscar(ItemServicoOrdem itenservicoordem) {
        String sql = "SELECT * FROM itenservicoordem WHERE cdItemServicoOrdem=?";
        ItemServicoOrdem retorno = new ItemServicoOrdem();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itenservicoordem.getCdItemServicoOrdem());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                OrdemDeServico ordemdeservico = new OrdemDeServico();
                Servico servico = new Servico();

                itenservicoordem.setValor(resultado.getDouble("valor"));
                servico.setCdServico(resultado.getInt("cdServico"));
                ordemdeservico.setCdOrdemDeServico(resultado.getInt("cdOrdemDeServico"));

                itenservicoordem.setOrdemDeServico(ordemdeservico);
                itenservicoordem.setServico(servico);

                retorno = itenservicoordem;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemServicoOrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
