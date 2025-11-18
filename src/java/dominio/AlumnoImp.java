/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dto.Respuesta;
import pojo.Alumno;
import java.util.List;
import modelo.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Lenovo
 */
public class AlumnoImp {

    public static List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                alumnos = conexionBD.selectList("alumno.obtener-todos");
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return alumnos;
    }

    public static List<Alumno> obtenerAlumnosPorCarrera(int idCarrera) {
        List<Alumno> alumnos = null;
        SqlSession conexionBD = MyBatisUtil.getSession();

        if (conexionBD != null) {
            try {
                alumnos = conexionBD.selectList("alumno.obtener-por-carrera", idCarrera);
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return alumnos;
    }

    public static Respuesta guardarFoto(int idAlumno, byte[] foto) {
        Respuesta respuesta = new Respuesta();
        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(idAlumno);
                alumno.setFoto(foto);
                int filasAfectadas = conexionBD.update("alumno.guardar-foto", alumno);
                conexionBD.commit();
                if (filasAfectadas > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Fotografía del alumno actualizada correctamente.");
                } else {
                    respuesta.setMensaje("No se pudo actualizar la imagen del alumno.");
                }
                conexionBD.close();
            } catch (Exception e) {
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setMensaje("No hay conexión al almacenamiento de la base de datos.");
        }

        return respuesta;
    }

    public static Alumno obtenerFoto(int idAlumno) {
        Alumno alumno = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                alumno = conexionBD.selectOne("alumno.obtener-foto", idAlumno);
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return alumno;
    }

}
