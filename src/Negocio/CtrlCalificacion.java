/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.ResourceCalificacion;
import dominiobroker.Calificacion;
import dominiobroker.Curso;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;


/**
 *
 * @author javie
 */
public class CtrlCalificacion {
    
    
    public ArrayList<Calificacion> getCalificaciones( ArrayList<Curso> cursos){
        ResourceCalificacion resource = new ResourceCalificacion();
        return resource.getCalificaciones(cursos);
    }
    //e we para enviar los datos ala api del chui pueden ahcerun metodo en control y en accesoa datos llamado enviar calificaciones y ahi se conectan ala api

    public void enviarCalificaciones(ArrayList<Calificacion> calificaciones) throws ProtocolException, IOException{
    ResourceCalificacion resource = new ResourceCalificacion();
         resource.enviarCalificaciones(calificaciones);
    }
    
}
