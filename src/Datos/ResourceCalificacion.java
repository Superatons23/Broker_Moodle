/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominiobroker.Calificacion;
import dominiobroker.Curso;
import dominiobroker.Maestro;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import servicios.MoodleConsumer;
import servicios.SistemaEscolarConsumer;

/**
 *
 * @author 123
 */
public class ResourceCalificacion {
     MoodleConsumer moodle = new MoodleConsumer();

    public ArrayList<Calificacion> getCalificaciones(ArrayList<Curso> cursos){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Obteniendo calificaciones de la plataforma Moodle...");
        ArrayList<Calificacion> cals=new ArrayList<>();
        for(Curso c:cursos){
         
             
             //convert cadena to  jsonObject
            JSONObject jsnobject = new JSONObject(moodle.getCalificacionesPorCursoId(c.getId()));

            //convert jsonObject to  JSONArray
            JSONArray jsonArray = jsnobject.getJSONArray("usergrades");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject explrObjectCourses = jsonArray.getJSONObject(i);


                Calificacion cal=new Calificacion();
                //obtener array contacts dentro del array courses del json
                JSONArray jsonArrayContacts = jsonArray.getJSONObject(i).optJSONArray("gradeitems");
                //for para obtener maestros del curso
                for (int j = 0; j < jsonArrayContacts.length(); j++) {
                    JSONObject explrObjectContacts = jsonArrayContacts.getJSONObject(j);
                
                    cal.setCalificacion(explrObjectContacts.getString("gradeformatted"));

                }
                cal.setIdAlumno(explrObjectCourses.getInt("userid"));
                cal.setIdCurso(explrObjectCourses.getInt("courseid"));
                
                
                cals.add(cal);

                
            }
        
       
    }
        System.out.println("Calificaciones obtenidas exitosamente desde la plataforma Moodle...");
       return cals;
        }
    public void enviarCalificaciones(ArrayList<Calificacion> calificaciones) throws IOException{
            SistemaEscolarConsumer sec=new SistemaEscolarConsumer();

        JSONObject obj = new JSONObject(calificaciones);


        JSONObject objtobeadded =  new JSONObject();
    JSONArray jsArray = new JSONArray(calificaciones);
  String postJsonData = jsArray.toString();
        System.out.println(postJsonData);

//        for (int i = 0; i < calificaciones.size(); i++) {
//        objtobeadded.put("idcalificacion", calificaciones.get(i).getCalificacion());
//        objtobeadded.put("idcurso", calificaciones.get(i).getIdCurso());
//        objtobeadded.put("idAlumno",calificaciones.get(i).getIdAlumno());
//        objtobeadded.put("calificacion",calificaciones.get(i).getCalificacion());
//        }
        
             sec.enviarCalificacion(postJsonData);
             sec.close();
        System.out.println("Calificaciones enviadas exitosamente a control escolar...");

      
 
    }
    
}
