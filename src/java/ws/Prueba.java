package ws;

import com.google.gson.Gson;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojo.OperacionAritmetica;
import pojo.OperacionSolicitud;


/**
 * @author Rob-ParGon
 */
@Path("saludo")
public class Prueba {

    @Context
    private UriInfo context;

    public Prueba() {
    }

    @Path("hola/{nombre}")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("nombre") String userName) {
        return "Hola "+userName;
    }
    
    @Path("sumar/{num1},{num2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OperacionAritmetica sumar(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2){
        OperacionAritmetica resultado = new OperacionAritmetica();
        resultado.setOperacion("suma");
        resultado.setOperandos(num1+","+num2);
        resultado.setResultado((float)num1+num2);
        return resultado;
    }
    
 
    @Path("restar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public OperacionAritmetica restar(@FormParam("num1") Integer num1,@FormParam("num2") Integer num2){
        OperacionAritmetica resultado = new OperacionAritmetica();
        resultado.setOperacion("resta");
        resultado.setOperandos(num1+","+num2);
        resultado.setResultado((float)num1-num2);
        return resultado;
    }
    
    
    @Path("multiplicar/{num1}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public OperacionAritmetica multiplicar(@PathParam ("num1") Integer num1, @FormParam ("num2") Integer num2){
        
        OperacionAritmetica resultado = new OperacionAritmetica();
        resultado.setOperacion("multiplicacion");
        resultado.setOperandos(num1+","+num2);
        resultado.setResultado((float)num1*num2);
        return resultado;
    }
    
    @Path("dividir")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OperacionAritmetica dividir(String json){
        Gson gson = new Gson();
        OperacionSolicitud datos = gson.fromJson(json, OperacionSolicitud.class);
        OperacionAritmetica resultado = new OperacionAritmetica();
        resultado.setOperacion(datos.getOperacion());
        resultado.setOperandos(datos.getNum1()+","+datos.getNum2());
        resultado.setResultado((float)datos.getNum1()/datos.getNum2());
        return resultado;        
    }
    
    
    @Path("calcular")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OperacionAritmetica calcular(String json){
        Gson gson = new Gson();
        OperacionSolicitud datos = gson.fromJson(json, OperacionSolicitud.class);
        OperacionAritmetica resultado = new OperacionAritmetica();
        
        float num1 = datos.getNum1();
        float num2 = datos.getNum2();
        String operacion = datos.getOperacion();
        float resul = 0;
        
        switch(operacion){
        
        case "suma":
            resul = (float)num1 + num2;
            break;
        case "resta":
            resul = (float)num1 - num2;
            break;
        case "multiplicacion":
            resul = (float)num1 * num2;
            break;
        case "division":
            if(num2 != 0){
            resul = (float)num1 / num2;   
            }else{
                throw new ArithmeticException();
            }
            break;
        default:
            throw new BadRequestException();
            //resultado.setOperacion("Operación no reconocida");
            //return resultado;
    }
        resultado.setOperacion(operacion);
        resultado.setOperandos(datos.getNum1()+","+datos.getNum2());
        resultado.setResultado(resul);
        return resultado;
    } 
}
