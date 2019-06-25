/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.ServicoDAO;
import assistencia.model.domain.Servico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ServicoService {

    private ServicoDAO servicoDAO = new ServicoDAO();

    public Servico buscar(Servico obj) throws SQLException {

        Servico obj1;
        obj1 = servicoDAO.buscar(obj);
        servicoDAO.getConnection().close();
        return obj1;

    }

    public List<Servico> listar() throws SQLException {

        List<Servico> obj1 = servicoDAO.listar();
        servicoDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(Servico obj) throws SQLException {

        Boolean bln = servicoDAO.inserir(obj);
        servicoDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(Servico obj) throws SQLException {
        Boolean bln = servicoDAO.alterar(obj);
        servicoDAO.getConnection().close();

        return bln;
    }

    public boolean remover(Servico obj) throws SQLException {
        Boolean bln = servicoDAO.remover(obj);
        servicoDAO.getConnection().close();

        return bln;
    }

}
