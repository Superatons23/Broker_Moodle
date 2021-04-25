/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author jesus
 */
public class Calificacion {
    int idCurso;
    int idAlumno;
    String calificacion;

    public Calificacion(int idCurso, int idAlumno, String calificacion) {
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
        this.calificacion = calificacion;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public Calificacion() {
    }

    @Override
    public String toString() {
        return "Calificacion{" + "idCurso=" + idCurso + ", idAlumno=" + idAlumno + ", calificacion=" + calificacion + '}';
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
