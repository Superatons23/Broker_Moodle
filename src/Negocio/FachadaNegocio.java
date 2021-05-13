/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import dominiobroker.Alumno;
import dominiobroker.Calificacion;
import dominiobroker.Curso;
import dominiobroker.Maestro;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class FachadaNegocio implements INegocio {

    @Override
    public ArrayList<Curso> getCursos() {
        CtrlCurso curso = new CtrlCurso();
       return curso.getCursos();
    }
    
    @Override
    public ArrayList<Calificacion> getCalificaciones( ArrayList<Curso> cursos) {
        CtrlCalificacion cal = new CtrlCalificacion();
       return cal.getCalificaciones(cursos);
    }
    
    @Override
    public ArrayList<Alumno> getAlumnos() {
        CtrlAlumno alumno= new CtrlAlumno();
       return alumno.getAlumnos();
    }

    @Override
    public ArrayList<Maestro> getMaestros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    @Override
    public void enviCalificacions(ArrayList<Calificacion> calificaciones) throws IOException {
        CtrlCalificacion cal = new CtrlCalificacion();
        cal.enviarCalificaciones(calificaciones);
    }
}
