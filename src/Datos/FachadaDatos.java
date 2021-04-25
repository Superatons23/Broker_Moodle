/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

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
    public ArrayList<Maestro> getMaestros() {
       ResourceMaestro maestro = new ResourceMaestro();
       return maestro.getMaestros();
    }
    
}
