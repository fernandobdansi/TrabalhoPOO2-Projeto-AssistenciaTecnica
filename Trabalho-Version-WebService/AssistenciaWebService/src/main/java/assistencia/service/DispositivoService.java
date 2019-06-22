/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.dao.DispositivoDAO;
import assistencia.model.domain.Dispositivo;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class DispositivoService {

    private DispositivoDAO dispositivoDAO = new DispositivoDAO();

    public Dispositivo buscar(Dispositivo obj) {
        return dispositivoDAO.buscar(obj);
    }

    public List<Dispositivo> listar() {
        return dispositivoDAO.listar();
    }

    public boolean inserir(Dispositivo obj) {
        return dispositivoDAO.inserir(obj);
    }

    public boolean alterar(Dispositivo obj) {
        return dispositivoDAO.alterar(obj);
    }

    public boolean remover(Dispositivo obj) {
        return dispositivoDAO.remover(obj);
    }

}
