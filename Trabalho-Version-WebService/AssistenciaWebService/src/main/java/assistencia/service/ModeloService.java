/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assistencia.service;

import assistencia.model.dao.ModeloDAO;
import assistencia.model.domain.Modelo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ModeloService {

    private ModeloDAO clienteDAO = new ModeloDAO();

    public Modelo buscar(Modelo obj) throws SQLException {

        Modelo obj1;
        obj1 = clienteDAO.buscar(obj);
        clienteDAO.getConnection().close();
        return obj1;

    }

    public List<Modelo> listar() throws SQLException {

        List<Modelo> obj1 = clienteDAO.listar();
        clienteDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(Modelo obj) throws SQLException {

        Boolean bln = clienteDAO.inserir(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(Modelo obj) throws SQLException {
        Boolean bln = clienteDAO.alterar(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean remover(Modelo obj) throws SQLException {
        Boolean bln = clienteDAO.remover(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

}
