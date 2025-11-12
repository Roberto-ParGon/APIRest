/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import dominio.AlumnoImp;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.Alumno;

/**
 *
 * @author Lenovo
 */
@Path("alumno")
public class AlumnoWS {

    @Path("obtener-todos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alumno> obtenerAlumnos() {
        return AlumnoImp.obtenerAlumnos();
    }

    @Path("obtener-todos-carrera/{idCarrera}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alumno> obtenerPorCarrera(@PathParam("idCarrera") Integer idCarrera) {
        if (idCarrera != null && idCarrera > 0) {
            return AlumnoImp.obtenerAlumnosPorCarrera(idCarrera);
        }
        throw new BadRequestException();
    }
}
