/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Maestro;
import java.io.BufferedReader;
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
public class ResourceCurso {

    public ArrayList<Curso> getCursos() {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        try {
            // Esto es lo que vamos a devolver
            StringBuilder resultado = new StringBuilder();
            // Crear un objeto de tipo URL
            URL url = new URL("https://cuervos.moodlecloud.com/webservice/rest/server.php?wstoken=7946744ecb0882f94fd3df4cae1c76bb&moodlewsrestformat=json&wsfunction=core_course_get_courses_by_field&field=category&value=1");

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

            //convert cadena to  jsonObject
            JSONObject jsnobject = new JSONObject(resultado.toString());

            //convert jsonObject to  JSONArray
            JSONArray jsonArray = jsnobject.getJSONArray("courses");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject explrObjectCourses = jsonArray.getJSONObject(i);

                
                //list Maestros
                ArrayList<Maestro> maestros = new ArrayList<>();

                //obtener array contacts dentro del array courses del json
                JSONArray jsonArrayContacts = jsonArray.getJSONObject(i).optJSONArray("contacts");
                //for para obtener maestros del curso
                for (int j = 0; j < jsonArrayContacts.length(); j++) {
                    JSONObject explrObjectContacts = jsonArrayContacts.getJSONObject(j);
                    maestros.add(new Maestro(explrObjectContacts.getInt("id"), explrObjectContacts.getString("fullname")));

                }
                ResourceAlumnos alumnos=new ResourceAlumnos();
                
                
                

                //agregar un curso ala lista
                cursos.add(new Curso(maestros, explrObjectCourses.getString("fullname"), explrObjectCourses.getString("shortname"),explrObjectCourses.getInt("id")));

            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursos;
    }
    public Curso getCursoById(Integer id){
        ArrayList<Curso> cursos=getCursos();
        
        for(Curso c:cursos){
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }
}
