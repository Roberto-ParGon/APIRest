/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;


/**
 * @author Rob-ParGon
 */
public class OperacionAritmetica {
    
    private String operacion;
    private String operandos;
    private Float resultado;

    public OperacionAritmetica() {
    }

    public OperacionAritmetica(String operacion, String operandos, Float resultado) {
        this.operacion = operacion;
        this.operandos = operandos;
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOperandos() {
        return operandos;
    }

    public void setOperandos(String operandos) {
        this.operandos = operandos;
    }

    public Float getResultado() {
        return resultado;
    }

    public void setResultado(Float resultado) {
        this.resultado = resultado;
    }
    
}
