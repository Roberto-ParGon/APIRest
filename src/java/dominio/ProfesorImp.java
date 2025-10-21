/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dto.Respuesta;
import java.util.List;
import modelo.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Profesor;

/**
 *
 * @author Lenovo
 */
public class ProfesorImp {

    public static List<Profesor> obtenerTodos() {
        List<Profesor> profesores = null;
        SqlSession conexionBD = MyBatisUtil.getSession();

        if (conexionBD != null) {
            try {
                profesores = conexionBD.selectList("profesor.obtener-todos");
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return profesores;
    }

    public static Respuesta registrar(Profesor profesor) {
        Respuesta respuesta = new Respuesta();

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                int filasAfectadas = conexionBD.insert("profesor.registrar", profesor);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Profesor " + profesor.getNombre() + " " + profesor.getApellidoPaterno() + " registrado exitosamente.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("Error al registrar al profesor.");
                }
                conexionBD.close();
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("No hubo conexión con la Base de Datos");
        }

        return respuesta;
    }
}
