/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.resource;

import assistencia.model.domain.ItemServicoOrdem;
import assistencia.service.ItemServicoOrdemService;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Fernando
 */
@Path("itenservicoordem")
public class ItemServicoOrdemResource {

    private ItemServicoOrdemService dispositivoService = new ItemServicoOrdemService();

    public ItemServicoOrdemResource() {
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    @Path("{cdItemServiceOrdem}")
    public ItemServicoOrdem buscar(@PathParam("cdItemServiceOrdem") int cdItemServiceOrdem) throws SQLException {
        ItemServicoOrdem itemServicoOrdem = new ItemServicoOrdem();
        itemServicoOrdem.setCdItemServicoOrdem(cdItemServiceOrdem);
        itemServicoOrdem = dispositivoService.buscar(itemServicoOrdem);
        return itemServicoOrdem;
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    public List<ItemServicoOrdem> listar() throws SQLException {
        List<ItemServicoOrdem> lista;
        lista = dispositivoService.listar();
        return lista;
    }

    @POST
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean inserir(ItemServicoOrdem itemServicoOrdem) throws SQLException {
        return dispositivoService.inserir(itemServicoOrdem);
    }

    @PUT
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean alterar(ItemServicoOrdem itemServicoOrdem) throws SQLException {
        return dispositivoService.alterar(itemServicoOrdem);
    }

    @DELETE
    @Path("{cdItemServiceOrdem}")
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean remover(@PathParam("cdItemServiceOrdem") int cdItemServiceOrdem) throws SQLException {
        ItemServicoOrdem itemServicoOrdem = new ItemServicoOrdem();
        itemServicoOrdem.setCdItemServicoOrdem(cdItemServiceOrdem);
        return dispositivoService.remover(itemServicoOrdem);
    }
}
