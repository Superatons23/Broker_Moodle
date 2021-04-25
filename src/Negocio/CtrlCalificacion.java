/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.ResourceCalificacion;
import Dominio.Calificacion;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class CtrlCalificacion {
    
    
    public ArrayList<Calificacion> getCalificaciones(){
        ResourceCalificacion resource = new ResourceCalificacion();
        return resource.getCalificaciones();
    }
}
