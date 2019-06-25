/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.DispositivoDAO;
import assistencia.model.domain.Dispositivo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class DispositivoService {

    private DispositivoDAO clienteDAO = new DispositivoDAO();

    public Dispositivo buscar(Dispositivo obj) throws SQLException {

        Dispositivo obj1;
        obj1 = clienteDAO.buscar(obj);
        clienteDAO.getConnection().close();
        return obj1;

    }

    public List<Dispositivo> listar() throws SQLException {

        List<Dispositivo> obj1 = clienteDAO.listar();
        clienteDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(Dispositivo obj) throws SQLException {

        Boolean bln = clienteDAO.inserir(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(Dispositivo obj) throws SQLException {
        Boolean bln = clienteDAO.alterar(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

    public boolean remover(Dispositivo obj) throws SQLException {
        Boolean bln = clienteDAO.remover(obj);
        clienteDAO.getConnection().close();

        return bln;
    }

}
