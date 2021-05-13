/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.FabricaDatos;
import Datos.FachadaDatos;
import dominiobroker.Alumno;
import dominiobroker.Curso;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class CtrlAlumno {
      public ArrayList<Alumno> getAlumnos(){
        FachadaDatos fachadaDatos = FabricaDatos.getFachadaDatos();
        return fachadaDatos.getAlumnos();
    }
}
