/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Maestro;
import Negocio.CtrlCurso;
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
 * @author jesus
 */
public class ResourceAlumnos {
    MoodleConsumer moodle = new MoodleConsumer();

    public ArrayList<Alumno> getAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        //response

        moodle.getAlumnos();
        //json array, no se ocupa objetojson por que ya es un array no se ocupa convertir a array
        JSONArray jsonArray = new JSONArray(moodle.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObjectCourses = jsonArray.getJSONObject(i);
            Alumno a = new Alumno();
            a.setNombre(explrObjectCourses.getString("fullname"));
            a.setId(explrObjectCourses.getInt("id"));
            
            ResourceCurso curso = new ResourceCurso();
            
            if (jsonArray.getJSONObject(i).has("enrolledcourses")) {
                //obtener array enrolledcourses dentro del array del json
                JSONArray jsonArrayCourses = jsonArray.getJSONObject(i).optJSONArray("enrolledcourses");
                ArrayList<Curso> cursos = new ArrayList<>();
                //for para obtener courses del alumno
                for (int j = 0; j < jsonArrayCourses.length(); j++) {
                    JSONObject objCourses = jsonArrayCourses.getJSONObject(j);
                    cursos.add(curso.getCursoById(objCourses.getInt("id")));
                }
                a.setCursos(cursos);
                alumnos.add(a);
            }

        }
        return alumnos;
    }
}
