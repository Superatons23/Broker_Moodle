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
public class Curso {
    
   private ArrayList<Maestro>maestros;
  private  ArrayList<Alumno>alumnos;
  private String fullName;
  private String shortName;
  private int id;

  

    public Curso(ArrayList<Maestro> maestros, String fullName, String shortName, int id) {
        this.maestros = maestros;
        this.fullName = fullName;
        this.shortName = shortName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public ArrayList<Maestro> getMaestros() {
        return maestros;
    }

    public void setMaestros(ArrayList<Maestro> maestros) {
        this.maestros = maestros;
    }

  

   
    
    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    
    
    
  

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
}
