/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.ItemServicoOrdemDAO;
import assistencia.model.domain.ItemServicoOrdem;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ItemServicoOrdemService {

    private ItemServicoOrdemDAO itemServicoOrdemDAO = new ItemServicoOrdemDAO();

    public ItemServicoOrdem buscar(ItemServicoOrdem obj) throws SQLException {

        ItemServicoOrdem obj1;
        obj1 = itemServicoOrdemDAO.buscar(obj);
        itemServicoOrdemDAO.getConnection().close();
        return obj1;

    }

    public List<ItemServicoOrdem> listar() throws SQLException {

        List<ItemServicoOrdem> obj1 = itemServicoOrdemDAO.listar();
        itemServicoOrdemDAO.getConnection().close();

        return obj1;

    }

    public boolean inserir(ItemServicoOrdem obj) throws SQLException {

        Boolean bln = itemServicoOrdemDAO.inserir(obj);
        itemServicoOrdemDAO.getConnection().close();

        return bln;
    }

    public boolean alterar(ItemServicoOrdem obj) throws SQLException {
        Boolean bln = itemServicoOrdemDAO.alterar(obj);
        itemServicoOrdemDAO.getConnection().close();

        return bln;
    }

    public boolean remover(ItemServicoOrdem obj) throws SQLException {
        Boolean bln = itemServicoOrdemDAO.remover(obj);
        itemServicoOrdemDAO.getConnection().close();

        return bln;
    }

}
