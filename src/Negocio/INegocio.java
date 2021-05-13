/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import dominiobroker.Alumno;
import dominiobroker.Curso;
import dominiobroker.Maestro;
import dominiobroker.Calificacion;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public interface INegocio {
    
    
    public ArrayList<Curso> getCursos();
    public ArrayList<Maestro> getMaestros();
    public ArrayList<Alumno> getAlumnos();
    public ArrayList<Calificacion> getCalificaciones( ArrayList<Curso> cursos);
     public void enviCalificacions(ArrayList<Calificacion> calificaciones) throws IOException; 
        
    
    
}
