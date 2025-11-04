/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import dominio.CatalogoImp;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.Rol;

/**
 *
 * @author Lenovo
 */
@Path("catalogos")
public class CatalogoWS {

    @Path("roles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rol> obtenerRoles() {
        return CatalogoImp.obtenerRoles();
    }
}
