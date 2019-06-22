/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assistencia.service;

import assistencia.model.dao.ModeloDAO;
import assistencia.model.domain.Modelo;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ModeloService {

    private ModeloDAO modeloDAO = new ModeloDAO();

    public Modelo buscar(Modelo obj) {
        return modeloDAO.buscar(obj);
    }

    public List<Modelo> listar() {
        return modeloDAO.listar();
    }

    public boolean inserir(Modelo obj) {
        return modeloDAO.inserir(obj);
    }

    public boolean alterar(Modelo obj) {
        return modeloDAO.alterar(obj);
    }

    public boolean remover(Modelo obj) {
        return modeloDAO.remover(obj);
    }

}
