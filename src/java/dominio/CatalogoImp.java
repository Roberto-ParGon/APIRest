/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import modelo.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Carrera;
import pojo.Facultad;
import pojo.Rol;

/**
 *
 * @author Lenovo
 */
public class CatalogoImp {

    public static List<Rol> obtenerRoles() {
        List<Rol> roles = null;
        SqlSession conexionBD = MyBatisUtil.getSession();

        if (conexionBD != null) {

            try {
                roles = conexionBD.selectList("catalogo.roles");
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return roles;
    }

    public static List<Facultad> obtenerFacultades() {
        List<Facultad> facultades = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                facultades = conexionBD.selectList("catalogo.obtener-facultades");
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return facultades;
    }

    public static List<Carrera> obtenerCarrerasFacultad(int idFacultad) {
        List<Carrera> carreras = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                carreras = conexionBD.selectList("catalogo.obtener-carreras-facultad", idFacultad);
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return carreras;
    }

}
