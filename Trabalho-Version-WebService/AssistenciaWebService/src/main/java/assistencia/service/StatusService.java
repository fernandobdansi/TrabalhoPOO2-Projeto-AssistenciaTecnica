/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.StatusDAO;
import assistencia.model.domain.Status;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class StatusService {

    private StatusDAO statusDAO = new StatusDAO();

    public Status buscar(Status obj) throws SQLException {

        Status obj1;
        obj1 = statusDAO.buscar(obj);
        statusDAO.getConnection().close();
        return obj1;

    }

    public List<Status> listar() throws SQLException {

        List<Status> obj1 = statusDAO.listar();
        statusDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(Status obj) throws SQLException {

        Boolean bln = statusDAO.inserir(obj);
        statusDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(Status obj) throws SQLException {
        Boolean bln = statusDAO.alterar(obj);
        statusDAO.getConnection().close();

        return bln;
    }

    public boolean remover(Status obj) throws SQLException {
        Boolean bln = statusDAO.remover(obj);
        statusDAO.getConnection().close();

        return bln;
    }

}
