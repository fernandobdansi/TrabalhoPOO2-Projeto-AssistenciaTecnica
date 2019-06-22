/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.MarcaDAO;
import assistencia.model.domain.Marca;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class MarcaService {

    private MarcaDAO marcaDAO = new MarcaDAO();

    public Marca buscar(Marca obj) {
        return marcaDAO.buscar(obj);
    }

    public List<Marca> listar() {
        return marcaDAO.listar();
    }

    public boolean inserir(Marca obj) {
        return marcaDAO.inserir(obj);
    }

    public boolean alterar(Marca obj) {
        return marcaDAO.alterar(obj);
    }

    public boolean remover(Marca obj) {
        return marcaDAO.remover(obj);
    }

}
