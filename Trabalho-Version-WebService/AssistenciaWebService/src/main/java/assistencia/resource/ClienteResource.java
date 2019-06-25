/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.resource;

import assistencia.model.dao.ClienteDAO;
import assistencia.model.domain.Cliente;
import assistencia.service.ClienteService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Fernando
 */
@Path("clientes")
public class ClienteResource {

    private ClienteService clienteService = new ClienteService();

    public ClienteResource() {
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    @Path("{cdCliente}")
    public Cliente buscar(@PathParam("cdCliente") int cdCliente) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCdCliente(cdCliente);
        cliente = clienteService.buscar(cliente);
        return cliente;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Cliente/list")
    public List<Cliente> listCliente() {
        List<Cliente> lista;

        ClienteDAO clienteDAO = new ClienteDAO();
        lista = clienteDAO.listar();

        return lista;
    }

    @GET
    @Produces("application/json ; charset=UTF-8")
    public List<Cliente> listar() throws SQLException {
        List<Cliente> lista;
        lista = clienteService.listar();
        return lista;
    }

    @POST
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean inserir(Cliente cliente) throws SQLException {
        return clienteService.inserir(cliente);
    }

    @PUT
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean alterar(Cliente cliente) throws SQLException {
        return clienteService.alterar(cliente);
    }

    @DELETE
    @Path("{cdCliente}")
    @Consumes("application/json ; charset=UTF-8")
    @Produces("text/plain")
    public boolean remover(@PathParam("cdCliente") int cdCliente) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCdCliente(cdCliente);
        return clienteService.remover(cliente);
    }
}
