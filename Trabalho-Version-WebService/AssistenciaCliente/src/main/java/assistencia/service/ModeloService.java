/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.domain.Modelo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Fernando
 */
public class ModeloService {

    private final String URL = "http://localhost:8080/AssistenciaWebService/modelo/";
    private final Client client = ClientBuilder.newClient();

    public Modelo buscar(Modelo obj) {
        try {
            WebTarget target = client.target(URL + obj.getCdModelo());
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            Modelo modelo = mapper.readValue(json, Modelo.class);
            return modelo;
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Modelo> listar() {
        try {
            WebTarget target = client.target(URL);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Modelo>> mapType = new TypeReference<List<Modelo>>() {
            };
            List<Modelo> lista = mapper.readValue(json, mapType);
            return lista;
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void inserir(Modelo obj) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(obj);
            target.request().post(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(Modelo obj) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(obj);
            target.request().put(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover(Modelo obj) {
        WebTarget target = client.target(URL + obj.getCdModelo());
        target.request().delete();
    }

}
