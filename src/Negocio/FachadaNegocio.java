/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Alumno;
import Dominio.Calificacion;
import Dominio.Curso;
import Dominio.Maestro;
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
    public ArrayList<Calificacion> getCalificaciones() {
        CtrlCalificacion cal = new CtrlCalificacion();
       return cal.getCalificaciones();
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
    
   
    
}
