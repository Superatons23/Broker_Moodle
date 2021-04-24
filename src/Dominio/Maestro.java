/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class Maestro {
    
    private ArrayList<Alumno> alumnos;
    private String nombre;

    public Maestro(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Maestro(ArrayList<Alumno> alumnos, String nombre) {
        this.alumnos = alumnos;
        this.nombre = nombre;
    }
    
    

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
     
    
    
}
