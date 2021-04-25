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
public interface IDatos {
    
    public ArrayList<Curso> getCursos();
    public ArrayList<Alumno> getAlumnos();
    public Curso getCursoById(Integer id);
    public ArrayList<Maestro> getMaestros();
    public ArrayList<Calificacion> getCalificaciones();
}
