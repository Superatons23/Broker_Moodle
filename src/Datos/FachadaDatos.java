/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Alumno;
import Dominio.Calificacion;
import Dominio.Curso;
import Dominio.Maestro;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class FachadaDatos implements IDatos {

    @Override
    public ArrayList<Curso> getCursos() {
       ResourceCurso curso = new ResourceCurso();
       return curso.getCursos();
    }
    
    @Override
    public ArrayList<Calificacion> getCalificaciones() {
       ResourceCalificacion cal = new ResourceCalificacion();
       return cal.getCalificaciones();
    }
    
    @Override
    public ArrayList<Maestro> getMaestros() {
       ResourceMaestro maestro = new ResourceMaestro();
       return maestro.getMaestros();
    }

    @Override
    public Curso getCursoById(Integer id) {
        ResourceCurso curso=new ResourceCurso();
        return curso.getCursoById(id);
    }
    @Override
    public ArrayList<Alumno> getAlumnos() {
       ResourceAlumnos alumno = new ResourceAlumnos();
       return alumno.getAlumnos();
    }

    
    
}
