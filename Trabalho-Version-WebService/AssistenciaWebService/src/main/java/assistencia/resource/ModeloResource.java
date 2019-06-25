/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.resource;

import assistencia.model.domain.Modelo;
import assistencia.service.ModeloService;
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
@Path("modelo")
public class ModeloResource {

    private ModeloService modeloService = new ModeloService();

    public ModeloResource() {
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    @Path("{cdCliente}")
    public Modelo buscar(@PathParam("cdCliente") int cdModelo) throws SQLException {
        Modelo modelo = new Modelo();
        modelo.setCdModelo(cdModelo);
        modelo = modeloService.buscar(modelo);
        return modelo;
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    public List<Modelo> listar() throws SQLException {
        List<Modelo> lista;
        lista = modeloService.listar();
        return lista;
    }

    @POST
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean inserir(Modelo modelo) throws SQLException {
        return modeloService.inserir(modelo);
    }

    @PUT
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean alterar(Modelo modelo) throws SQLException {
        return modeloService.alterar(modelo);
    }

    @DELETE
    @Path("{cdModelo}")
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean remover(@PathParam("cdCliente") int cdModelo) throws SQLException {
        Modelo modelo = new Modelo();
        modelo.setCdModelo(cdModelo);
        return modeloService.remover(modelo);
    }
}
