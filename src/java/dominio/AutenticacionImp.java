/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dto.RSAutenticacionAdmin;
import java.util.HashMap;
import java.util.LinkedHashMap;
import modelo.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Profesor;

/**
 *
 * @author Lenovo
 */
public class AutenticacionImp {
    
    public static RSAutenticacionAdmin autenticarAdministracion(String noPersonal, String password){
        RSAutenticacionAdmin respuesta = new RSAutenticacionAdmin();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("noPersonal", noPersonal); //id del param del Mapper, param del método.
                parametros.put("password", password);
                Profesor profesor = conexionBD.selectOne("autenticacion.administrador", parametros);
                if(profesor != null){
                    respuesta.setError(false);
                    respuesta.setMensaje("Credenciales de " + profesor.getNombre() + " correctas.");
                    respuesta.setProfesor(profesor);
                }else{
                    //Flujo alterno 2 ; Credenciales incorrectas.
                   respuesta.setError(true);
                   respuesta.setMensaje("Credenciales incorrectas.");
                }
                conexionBD.close();
            } catch (Exception e) {
                //Flujo alterno 3 : Error en la consulta del query.
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            //Flujo alterno 1 : No hay conexión con la base de datos.
            respuesta.setError(true);
            respuesta.setMensaje("La conexión a la información no se encuentra disponible.");
        }
        return respuesta;
    }
}
 