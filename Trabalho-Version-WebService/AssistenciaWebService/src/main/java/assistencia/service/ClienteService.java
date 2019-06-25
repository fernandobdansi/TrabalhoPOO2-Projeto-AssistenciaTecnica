/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.ClienteDAO;
import assistencia.model.domain.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente buscar(Cliente obj) throws SQLException {

        Cliente obj1;
        obj1 = clienteDAO.buscar(obj);
        clienteDAO.getConnection().close();
        return obj1;

    }

    public List<Cliente> listar() throws SQLException {

        List<Cliente> obj1 = clienteDAO.listar();
        clienteDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(Cliente obj) throws SQLException {

        Boolean bln = clienteDAO.inserir(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(Cliente obj) throws SQLException {
        Boolean bln = clienteDAO.alterar(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean remover(Cliente obj) throws SQLException {
        Boolean bln = clienteDAO.remover(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

}
