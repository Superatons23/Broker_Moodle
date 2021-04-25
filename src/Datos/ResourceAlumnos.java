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

/**
 *
 * @author jesus
 */
public class ResourceAlumnos {

    public ArrayList<Alumno> getAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            // Esto es lo que vamos a devolver
            StringBuilder resultado = new StringBuilder();
            // Crear un objeto de tipo URL
            URL url = new URL("https://cuervos.moodlecloud.com/webservice/rest/server.php?wstoken=7946744ecb0882f94fd3df4cae1c76bb&moodlewsrestformat=json&wsfunction=core_enrol_get_enrolled_users&courseid=1");

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

            //json array, no se ocupa objetojson por que ya es un array no se ocupa convertir a array
            JSONArray jsonArray = new JSONArray(resultado.toString());

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

        } catch (MalformedURLException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }
}
