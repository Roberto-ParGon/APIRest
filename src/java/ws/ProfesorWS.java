/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dominio.ProfesorImp;
import dto.Respuesta;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.Profesor;

/**
 *
 * @author Lenovo
 */
@Path("profesor")
public class ProfesorWS {

    @Path("obtener-todos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profesor> obtenerTodos() {
        return ProfesorImp.obtenerTodos();
    }

    @Path("registrar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta registrar(String json) {
        Gson gson = new Gson();
        try {
            Profesor profesor = gson.fromJson(json, Profesor.class);
            return ProfesorImp.registrar(profesor);
        } catch (JsonSyntaxException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Path("editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta editar(String json) {
        Gson gson = new Gson();
        try {
            Profesor profesor = gson.fromJson(json, Profesor.class);
            return ProfesorImp.editar(profesor);
        } catch (JsonSyntaxException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
    
    @Path("eliminar/{idProfesor}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta eliminar(@PathParam("idProfesor") int idProfesor){
        try {
            return ProfesorImp.eliminar(idProfesor);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
