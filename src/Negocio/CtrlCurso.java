/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.FabricaDatos;
import Datos.FachadaDatos;
import dominiobroker.Curso;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class CtrlCurso {
    
    
    public ArrayList<Curso> getCursos(){
        FachadaDatos fachadaDatos = FabricaDatos.getFachadaDatos();
        
        
        return fachadaDatos.getCursos();
    }
    public Curso getCursoById(Integer id){
        FachadaDatos fachadaDatos = FabricaDatos.getFachadaDatos();
        return fachadaDatos.getCursoById(id);
    }
}
