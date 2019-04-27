/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.model.dao;

import assistencia.model.domain.Cliente;
import assistencia.model.domain.Dispositivo;
import assistencia.model.domain.ItemServicoOrdem;
import assistencia.model.domain.OrdemDeServico;
import assistencia.model.domain.Status;
import assistencia.model.domain.Tecnico;
import java.sql.Connection;
import java.sql.Date;
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
public class OrdemDeServicoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(OrdemDeServico ordemdeservico) {

        String sql;

        if (ordemdeservico.getDataSaida() != null) {
            sql = "INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus, dataSaida) VALUES('?','?','?','?','?','?','?','?');";
        } else {
            sql = "INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('?','?','?','?','?','?','?');";
        }

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(ordemdeservico.getDataEntrada()));
            stmt.setString(2, ordemdeservico.getDescricaoProblema());
            stmt.setDouble(3, ordemdeservico.getValorTotal());
            stmt.setInt(4, ordemdeservico.getCliente().getCdCliente());
            stmt.setInt(5, ordemdeservico.getTecnico().getCdTecnico());
            stmt.setInt(6, ordemdeservico.getDispositivo().getCdDispositivo());
            stmt.setInt(7, ordemdeservico.getStatus().getCdStatus());

            if (ordemdeservico.getDataSaida() != null) {
                stmt.setDate(8, Date.valueOf(ordemdeservico.getDataSaida()));
            }

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDeServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(OrdemDeServico ordemdeservico) {

        String sql;

        if (ordemdeservico.getDataSaida() != null) {
            sql = "UPDATE ordemdeservico SET dataEntrada=?, descricaoProblema=?, valorTotal=?, cdCliente=?, cdTecnico=?, cdDispositivo=?, cdStatus=?, dataSaida=? WHERE cdOrdemDeServico=?;";
        } else {
            sql = "UPDATE ordemdeservico SET dataEntrada=?, descricaoProblema=?, valorTotal=?, cdCliente=?, cdTecnico=?, cdDispositivo=?, cdStatus=? WHERE cdOrdemDeServico=?;";
        }

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(ordemdeservico.getDataEntrada()));
            stmt.setString(2, ordemdeservico.getDescricaoProblema());
            stmt.setDouble(3, ordemdeservico.getValorTotal());
            stmt.setInt(4, ordemdeservico.getCliente().getCdCliente());
            stmt.setInt(5, ordemdeservico.getTecnico().getCdTecnico());
            stmt.setInt(6, ordemdeservico.getDispositivo().getCdDispositivo());
            stmt.setInt(7, ordemdeservico.getStatus().getCdStatus());

            if (ordemdeservico.getDataSaida() != null) {
                stmt.setDate(8, Date.valueOf(ordemdeservico.getDataSaida()));
            }

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDeServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(OrdemDeServico ordemdeservico) {
        String sql = "DELETE FROM ordemdeservico WHERE cdOrdemDeServico=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ordemdeservico.getCdOrdemDeServico());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDeServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<OrdemDeServico> listar() {
        String sql = "SELECT * FROM ordemdeservico";
        List<OrdemDeServico> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                OrdemDeServico ordemdeservico = new OrdemDeServico();
                Cliente cliente = new Cliente();
                Tecnico tecnico = new Tecnico();
                Status status = new Status();
                Dispositivo dispositivo = new Dispositivo();
                List<ItemServicoOrdem> itemServicoOrdem = new ArrayList();

                ordemdeservico.setCdOrdemDeServico(resultado.getInt("cdOrdemDeServico"));
                ordemdeservico.setDataEntrada(resultado.getDate("dataEntrada").toLocalDate());
                ordemdeservico.setDataSaida(resultado.getDate("dataSaida").toLocalDate());
                ordemdeservico.setValorTotal(resultado.getDouble("valorTotal"));
                ordemdeservico.setDescricaoProblema(resultado.getString("descricaoProblema"));
                cliente.setCdCliente(resultado.getInt("cdCliente"));
                tecnico.setCdTecnico(resultado.getInt("cdTecnico"));
                status.setCdStatus(resultado.getInt("cdStatus"));
                dispositivo.setCdDispositivo(resultado.getInt("cdDispositivo"));

                //Obtendo os dados completos do Cliente associado à OrdemDeServico
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.setConnection(connection);
                cliente = clienteDAO.buscar(cliente);

                TecnicoDAO tecnicoDAO = new TecnicoDAO();
                tecnicoDAO.setConnection(connection);
                tecnico = tecnicoDAO.buscar(tecnico);

                StatusDAO statusDAO = new StatusDAO();
                statusDAO.setConnection(connection);
                status = statusDAO.buscar(status);

                DispositivoDAO dispositivoDAO = new DispositivoDAO();
                dispositivoDAO.setConnection(connection);
                dispositivo = dispositivoDAO.buscar(dispositivo);

                //Obtendo os dados completos dos Itens de OrdemDeServico associados à OrdemDeServico
                ItemServicoOrdemDAO itemServicoOrdemDAO = new ItemServicoOrdemDAO();
                itemServicoOrdemDAO.setConnection(connection);
                itemServicoOrdem = itemServicoOrdemDAO.listarPorOrdemDeServico(ordemdeservico);

                ordemdeservico.setCliente(cliente);
                ordemdeservico.setItemServicoOrdem(itemServicoOrdem);
                retorno.add(ordemdeservico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDeServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public OrdemDeServico buscar(OrdemDeServico ordemdeservico) {
        String sql = "SELECT * FROM ordemdeservico WHERE cdOrdemDeServico=?";
        OrdemDeServico retorno = new OrdemDeServico();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ordemdeservico.getCdOrdemDeServico());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                Cliente cliente = new Cliente();
                Tecnico tecnico = new Tecnico();
                Status status = new Status();
                Dispositivo dispositivo = new Dispositivo();

                ordemdeservico.setCdOrdemDeServico(resultado.getInt("cdOrdemDeServico"));
                ordemdeservico.setDataEntrada(resultado.getDate("dataEntrada").toLocalDate());
                ordemdeservico.setDataEntrada(resultado.getDate("dataSaida").toLocalDate());
                ordemdeservico.setValorTotal(resultado.getDouble("valorTotal"));
                cliente.setCdCliente(resultado.getInt("cdCliente"));
                tecnico.setCdTecnico(resultado.getInt("cdTecnico"));
                status.setCdStatus(resultado.getInt("cdStatus"));
                dispositivo.setCdDispositivo(resultado.getInt("cdDispositivo"));
                ordemdeservico.setCliente(cliente);
                ordemdeservico.setTecnico(tecnico);
                ordemdeservico.setStatus(status);
                ordemdeservico.setDispositivo(dispositivo);
                retorno = ordemdeservico;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDeServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
