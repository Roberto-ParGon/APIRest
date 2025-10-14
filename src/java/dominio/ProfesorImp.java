/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

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

}
