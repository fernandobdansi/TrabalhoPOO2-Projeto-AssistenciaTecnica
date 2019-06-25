/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.MarcaDAO;
import assistencia.model.domain.Marca;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class MarcaService {

    private MarcaDAO clienteDAO = new MarcaDAO();

    public Marca buscar(Marca obj) throws SQLException {

        Marca obj1;
        obj1 = clienteDAO.buscar(obj);
        clienteDAO.getConnection().close();
        return obj1;

    }

    public List<Marca> listar() throws SQLException {

        List<Marca> obj1 = clienteDAO.listar();
        clienteDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(Marca obj) throws SQLException {

        Boolean bln = clienteDAO.inserir(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(Marca obj) throws SQLException {
        Boolean bln = clienteDAO.alterar(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean remover(Marca obj) throws SQLException {
        Boolean bln = clienteDAO.remover(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

}