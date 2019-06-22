/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.service;

import assistencia.model.domain.Marca;
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
public class MarcaService {

    private final String URL = "http://localhost:8080/AssistenciaWebService/marca/";
    private final Client client = ClientBuilder.newClient();

    public Marca buscar(Marca obj) {
        try {
            WebTarget target = client.target(URL + obj.getCdMarca());
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            Marca marca = mapper.readValue(json, Marca.class);
            return marca;
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Marca> listar() {
        try {
            WebTarget target = client.target(URL);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Marca>> mapType = new TypeReference<List<Marca>>() {
            };
            List<Marca> lista = mapper.readValue(json, mapType);
            return lista;
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void inserir(Marca obj) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(obj);
            target.request().post(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(Marca obj) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(obj);
            target.request().put(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover(Marca obj) {
        WebTarget target = client.target(URL + obj.getCdMarca());
        target.request().delete();
    }

}
