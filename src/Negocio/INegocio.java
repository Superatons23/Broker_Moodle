/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dominio.Curso;
import Dominio.Maestro;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public interface INegocio {
    
    
    public ArrayList<Curso> getCursos();
    public ArrayList<Maestro> getMaestros();
    
    
}
