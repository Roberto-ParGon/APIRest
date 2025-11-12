/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

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

}
