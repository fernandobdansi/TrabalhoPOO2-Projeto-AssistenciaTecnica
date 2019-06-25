/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assistencia.resource;

import assistencia.model.domain.Dispositivo;
import assistencia.service.DispositivoService;
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
@Path("dispositivo")
public class DispositivoResource {

    private DispositivoService dispositivoService = new DispositivoService();

    public DispositivoResource() {
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    @Path("{cdDispositivo}")
    public Dispositivo buscar(@PathParam("cdDispositivo") int cdDispositivo) throws SQLException {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setCdDispositivo(cdDispositivo);
        dispositivo = dispositivoService.buscar(dispositivo);
        return dispositivo;
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    public List<Dispositivo> listar() throws SQLException {
        List<Dispositivo> lista;
        lista = dispositivoService.listar();
        return lista;
    }

    @POST
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean inserir(Dispositivo dispositivo) throws SQLException {
        return dispositivoService.inserir(dispositivo);
    }

    @PUT
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean alterar(Dispositivo dispositivo) throws SQLException {
        return dispositivoService.alterar(dispositivo);
    }

    @DELETE
    @Path("{cdDispositivo}")
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean remover(@PathParam("cdDispositivo") int cdDispositivo) throws SQLException {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setCdDispositivo(cdDispositivo);
        return dispositivoService.remover(dispositivo);
    }
}
