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

/**
 *
 * @author javie
 */
public class ResourceCalificacion {
    
    
    public ArrayList<Calificacion> getCalificaciones(ArrayList<Curso> cursos){
        ArrayList<Calificacion> cals=new ArrayList<>();
        for(Curso c:cursos){
         
        try {
            // Esto es lo que vamos a devolver
            StringBuilder resultado = new StringBuilder();
            // Crear un objeto de tipo URL
            URL url = new URL("https://cuervos.moodlecloud.com/webservice/rest/server.php?wstoken=7946744ecb0882f94fd3df4cae1c76bb&moodlewsrestformat=json&wsfunction=gradereport_user_get_grade_items&courseid="+c.getId());
            
            // Abrir la conexión e indicar que será de tipo GET
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            try ( // Búferes para leer
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                String linea;
                // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
                while ((linea = rd.readLine()) != null) {
                    resultado.append(linea);
                }
                // Cerrar el BufferedReader
            }
            // Regresar resultado, pero como cadena, no como StringBuilder
             resultado.toString();
             
             //convert cadena to  jsonObject
            JSONObject jsnobject = new JSONObject(resultado.toString());

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
                    System.out.println("...........");
                    System.out.println(explrObjectContacts.getString("gradeformatted"));
                    cal.setCalificacion(explrObjectContacts.getString("gradeformatted"));

                }
                cal.setIdAlumno(explrObjectCourses.getInt("userid"));
                cal.setIdCurso(explrObjectCourses.getInt("courseid"));
                
                
                cals.add(cal);

                
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       return cals;
        }
    public void enviarCalificaciones(ArrayList<Calificacion> calificaciones) throws IOException{
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
  System.out.println("nSending 'POST' request to URL : " + url);
  System.out.println("Post Data : " + postJsonData);
  System.out.println("Response Code : " + responseCode);
 
  BufferedReader in = new BufferedReader(
  new InputStreamReader(con.getInputStream()));
  String output;
  StringBuffer response = new StringBuffer();
 
  while ((output = in.readLine()) != null) {
   response.append(output);
  }
  in.close();
 
  //printing result from response
  System.out.println(response.toString());
    }
    
}
