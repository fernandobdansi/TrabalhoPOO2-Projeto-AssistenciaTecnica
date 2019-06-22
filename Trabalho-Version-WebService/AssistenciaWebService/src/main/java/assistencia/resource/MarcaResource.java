/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.resource;

import assistencia.model.domain.Marca;
import assistencia.service.MarcaService;
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
@Path("marca")
public class MarcaResource {

    private MarcaService marcaService = new MarcaService();

    public MarcaResource() {
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    @Path("{cdCliente}")
    public Marca buscar(@PathParam("cdCliente") int cdMarca) {
        Marca marca = new Marca();
        marca.setCdMarca(cdMarca);
        marca = marcaService.buscar(marca);
        return marca;
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    public List<Marca> listar() {
        List<Marca> lista;
        lista = marcaService.listar();
        return lista;
    }

    @POST
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean inserir(Marca marca) {
        return marcaService.inserir(marca);
    }

    @PUT
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean alterar(Marca marca) {
        return marcaService.alterar(marca);
    }

    @DELETE
    @Path("{cdMarca}")
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean remover(@PathParam("cdCliente") int cdMarca) {
        Marca marca = new Marca();
        marca.setCdMarca(cdMarca);
        return marcaService.remover(marca);
    }
}
