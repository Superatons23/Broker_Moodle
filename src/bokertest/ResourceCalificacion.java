/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokertest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class ResourceCalificacion {
    
    
    public void getCalificaciones(){
        
        
         
        try {
            // Esto es lo que vamos a devolver
            StringBuilder resultado = new StringBuilder();
            // Crear un objeto de tipo URL
            URL url = new URL("https://cuervos.moodlecloud.com/webservice/rest/server.php?wstoken=7946744ecb0882f94fd3df4cae1c76bb&moodlewsrestformat=json&wsfunction=gradereport_user_get_grade_items&courseid=5");
            
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
             
             System.out.println(resultado.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResourceCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
