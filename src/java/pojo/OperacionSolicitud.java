/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;


/**
 * @author Rob-ParGon
 */
public class OperacionSolicitud {
    private String operacion;
    private Integer num1;
    private Integer num2;

    public OperacionSolicitud() {
    }

    public OperacionSolicitud(String operacion, Integer num1, Integer num2) {
        this.operacion = operacion;
        this.num1 = num1;
        this.num2 = num2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }
}
