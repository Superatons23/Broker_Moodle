/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author javie
 */
public class FabricaFachada {
    
    public static FachadaNegocio getFachadaNegocio(){
        return new FachadaNegocio();
    }
    
    
}
