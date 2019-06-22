/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rafael
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(assistencia.resource.DispositivoResource.class);
        resources.add(assistencia.resource.ClienteResource.class);
        resources.add(assistencia.resource.ItemServicoOrdemResource.class);
        resources.add(assistencia.resource.MarcaResource.class);
        resources.add(assistencia.resource.ModeloResource.class);
        resources.add(assistencia.resource.OrdemDeServicoResource.class);
        resources.add(assistencia.resource.ServicoResource.class);
        resources.add(assistencia.resource.StatusResource.class);
        resources.add(assistencia.resource.TecnicoResource.class);
    }
    
}
