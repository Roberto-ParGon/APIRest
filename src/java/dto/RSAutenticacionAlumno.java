/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import pojo.Alumno;

/**
 *
 * @author Lenovo
 */
public class RSAutenticacionAlumno {

    private boolean error;
    private String mensaje;
    private Alumno alumno;

    public RSAutenticacionAlumno() {
    }

    public RSAutenticacionAlumno(boolean error, String mensaje, Alumno alumno) {
        this.error = error;
        this.mensaje = mensaje;
        this.alumno = alumno;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
