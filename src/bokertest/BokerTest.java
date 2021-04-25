/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokertest;

import Datos.ResourceCalificacion;
import Dominio.Alumno;
import Dominio.Calificacion;
import Dominio.Curso;
import Negocio.CtrlCalificacion;
import Negocio.FabricaFachada;
import Negocio.FachadaNegocio;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class BokerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //obtener fachada negocio
        FachadaNegocio fachadaNegocio = FabricaFachada.getFachadaNegocio();

        //obtener lista de cursos
        ArrayList<Curso> cursos = fachadaNegocio.getCursos();

        ArrayList<Alumno> alumnos = fachadaNegocio.getAlumnos();
        for (Alumno a:alumnos) {
            System.out.println(a.toString());
        }
        
        ArrayList<Calificacion> cals=fachadaNegocio.getCalificaciones();
        for (Calificacion c:cals) {
            System.out.println(c.toString());
        }
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("Curso");
            System.out.println("id " + cursos.get(i).getId());
            System.out.println("fullname " + cursos.get(i).getFullName());

            for (int j = 0; j < cursos.get(i).getMaestros().size(); j++) {
                System.out.println("    Maestros");
                System.out.println("    id " + cursos.get(i).getMaestros().get(j).getId());
                System.out.println("    fullname " + cursos.get(i).getMaestros().get(j).getNombre());
            }

        }

    }

}
