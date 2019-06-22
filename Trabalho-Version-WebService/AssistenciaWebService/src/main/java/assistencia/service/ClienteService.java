/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assistencia.service;

import assistencia.model.dao.ClienteDAO;
import assistencia.model.domain.Cliente;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente buscar(Cliente obj) {
        return clienteDAO.buscar(obj);
    }

    public List<Cliente> listar() {
        return clienteDAO.listar();
    }

    public boolean inserir(Cliente obj) {
        return clienteDAO.inserir(obj);
    }

    public boolean alterar(Cliente obj) {
        return clienteDAO.alterar(obj);
    }

    public boolean remover(Cliente obj) {
        return clienteDAO.remover(obj);
    }

}
