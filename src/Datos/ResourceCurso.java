/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominiobroker.Alumno;
import dominiobroker.Curso;
import dominiobroker.Maestro;
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
import servicios.MoodleConsumer;

/**
 *
 * @author ruben
 */
public class ResourceCurso {
        MoodleConsumer moodle = new MoodleConsumer();

    public ArrayList<Curso> getCursos() {
        ArrayList<Curso> cursos = new ArrayList<Curso>();


            //convert cadena to  jsonObject
            JSONObject jsnobject = new JSONObject(moodle.getCursos());

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
