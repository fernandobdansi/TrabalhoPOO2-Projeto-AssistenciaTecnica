/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.TecnicoDAO;
import assistencia.model.domain.Tecnico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class TecnicoService {

    private TecnicoDAO tecnicoDAO = new TecnicoDAO();

    public Tecnico buscar(Tecnico obj) throws SQLException {

        Tecnico obj1;
        obj1 = tecnicoDAO.buscar(obj);
        tecnicoDAO.getConnection().close();
        return obj1;

    }

    public List<Tecnico> listar() throws SQLException {

        List<Tecnico> obj1 = tecnicoDAO.listar();
        tecnicoDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(Tecnico obj) throws SQLException {

        Boolean bln = tecnicoDAO.inserir(obj);
        tecnicoDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(Tecnico obj) throws SQLException {
        Boolean bln = tecnicoDAO.alterar(obj);
        tecnicoDAO.getConnection().close();

        return bln;
    }

    public boolean remover(Tecnico obj) throws SQLException {
        Boolean bln = tecnicoDAO.remover(obj);
        tecnicoDAO.getConnection().close();

        return bln;
    }

}
