/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class SistemaEscolarConsumer {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/APIREST/webresources/entity.registrocalificaciones";

    public SistemaEscolarConsumer() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget= client.target(BASE_URI);
    }

    public void enviarCalificacion(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }
    
    
    public void close() {
        client.close();
    }

}
