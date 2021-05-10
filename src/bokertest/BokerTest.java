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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author desconocido
 */
public class BokerTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //obtener fachada negocio
        FachadaNegocio fachadaNegocio = FabricaFachada.getFachadaNegocio();

        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                try {
                    
                    ArrayList<Calificacion> cals = fachadaNegocio.getCalificaciones(fachadaNegocio.getCursos());
                    
                    fachadaNegocio.enviCalificacions(cals);
                } catch (IOException ex) {
                    Logger.getLogger(BokerTest.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            }
        };
        // scheduling the task at fixed rate delay
        timer.scheduleAtFixedRate(tt, 2000, 10000);

    }

}
