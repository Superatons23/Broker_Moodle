/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Calificacion;
import Dominio.Curso;
import Dominio.Maestro;
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
         
               moodle.getAlumnos();

            // Regresar resultado, pero como cadena, no como StringBuilder
             moodle.toString();
             
             //convert cadena to  jsonObject
            JSONObject jsnobject = new JSONObject(moodle.toString());

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
        System.out.println("Enviando calificaciones a sistema Control Escolar...");
           String url = "http://localhost:8080/APIREST/webresources/entity.calificacion";
       URL obj = new URL(url);
  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
        // Setting basic post request
  con.setRequestMethod("POST");
  con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
  con.setRequestProperty("Content-Type","application/json");
 //esta cadena se envia
  JSONArray jsArray = new JSONArray(calificaciones);

  String postJsonData = jsArray.toString();

  // Send post request
  con.setDoOutput(true);
  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
  wr.writeBytes(postJsonData);
  wr.flush();
  wr.close();
 
  int responseCode = con.getResponseCode();
 
 
  BufferedReader in = new BufferedReader(
  new InputStreamReader(con.getInputStream()));
  String output;
  StringBuffer response = new StringBuffer();
 
  while ((output = in.readLine()) != null) {
   response.append(output);
  }
  in.close();
 
 
        System.out.println("Calificaciones enviadas exitosamente a control escolar...");
    }
    
}
