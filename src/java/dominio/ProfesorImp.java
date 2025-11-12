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

    public static Respuesta editar(Profesor profesor) {
        Respuesta respuesta = new Respuesta();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                int filasAfectadas = conexionBD.update("profesor.editar", profesor);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Profesor " + profesor.getNombre() + " " + profesor.getApellidoPaterno() + " editado correctamente.");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("Error al editar al profesor.");
                }
                conexionBD.close();
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("No hubo conexión con la Base de Datos.");
        }
        return respuesta;
    }

    public static Respuesta eliminar(int idProfesor) {
        Respuesta respuesta = new Respuesta();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (idProfesor == 0) {
            respuesta.setError(true);
            respuesta.setMensaje("El ID del profesor no es valido.");
            return respuesta;
        }
        if (conexionBD != null) {
            try {
                int filasAfectadas = conexionBD.delete("profesor.eliminar", idProfesor);
                conexionBD.commit();

                if (filasAfectadas > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Profesor eliminado exitosamente");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("Error al eliminar al profesor.");
                }
                conexionBD.close();
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("No hubo conexión con la base de datos");
        }
        return respuesta;
    }

    public static Respuesta guardarFoto(int idProfesor, byte[] foto) {
        Respuesta respuesta = new Respuesta();
        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Profesor profesor = new Profesor();
                profesor.setIdProfesor(idProfesor);
                profesor.setFoto(foto);
                int filasAfectadas = conexionBD.update("profesor.guardar-foto", profesor);
                conexionBD.commit();
                if (filasAfectadas > 0) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Fotografía del profesor actualizada correctamente.");
                } else {
                    respuesta.setMensaje("No se pudo actualizar la imagen del profesor.");
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

    public static Profesor obtenerFoto(int idProfesor) {
        Profesor profesor = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                profesor = conexionBD.selectOne("profesor.obtener-foto", idProfesor);
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return profesor;
    }

}
