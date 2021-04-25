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
public interface IDatos {
    
    public ArrayList<Curso> getCursos();
    public ArrayList<Maestro> getMaestros();
}
