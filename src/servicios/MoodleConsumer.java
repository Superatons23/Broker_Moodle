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

public class MoodleConsumer {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://cuervos.moodlecloud.com/webservice/rest";

    public MoodleConsumer() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
    }

    public String getAlumnos() throws ClientErrorException {
        webTarget = client.target(BASE_URI).path("{page}")
                    .resolveTemplate("page", "server.php")
                    .queryParam("wstoken", "df4353e926da3f515f1d35a05f48d6a1")
                    .queryParam("moodlewsrestformat", "json")
                    .queryParam("wsfunction", "core_enrol_get_enrolled_users")
                    .queryParam("courseid", "1");
        String response = webTarget.request(MediaType.APPLICATION_JSON)
            .get(String.class);
            //System.out.println(response);
            return response;
    }
    
    public String  getCursos() throws ClientErrorException {
        webTarget = client.target(BASE_URI).path("{page}")
                    .resolveTemplate("page", "server.php")
                    .queryParam("wstoken", "df4353e926da3f515f1d35a05f48d6a1")
                    .queryParam("moodlewsrestformat", "json")
                    .queryParam("wsfunction", "core_course_get_courses_by_field")
                    .queryParam("field", "category")
                    .queryParam("value", "1");
        String response = webTarget.request(MediaType.APPLICATION_JSON)
            .get(String.class);
            //System.out.println(response);
            return response;
    }
    
    public String getCalificacionesPorCursoId(int courseid) throws ClientErrorException {
        webTarget = client.target(BASE_URI).path("{page}")
                    .resolveTemplate("page", "server.php")
                    .queryParam("wstoken", "df4353e926da3f515f1d35a05f48d6a1")
                    .queryParam("moodlewsrestformat", "json")
                    .queryParam("wsfunction", "gradereport_user_get_grade_items")
                    .queryParam("courseid", courseid);
        String response = webTarget.request(MediaType.APPLICATION_JSON)
            .get(String.class);
            //System.out.println(response);
            return response;
    }
    
    
    public void close() {
        client.close();
    }

}