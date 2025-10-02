package ws;

import java.util.Set;

/**
 * @author Rob-ParGon
 */
@javax.ws.rs.ApplicationPath("v1")
public class ApplicationConfig extends javax.ws.rs.core.Application {

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
        resources.add(ws.AlumnoWS.class);
        resources.add(ws.AutenticacionWS.class);
        resources.add(ws.ProfesorWS.class);
        resources.add(ws.Prueba.class);
    }
    
}
