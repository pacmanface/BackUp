import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class PersonServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String requestUrl = req.getRequestURI();
        String name = requestUrl.substring("/people/".length());

        Person person = DataStore.getInstance().getPerson(name);

        if(person != null){
            String json = "{\n";
            json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
            json += "\"about\": " + JSONObject.quote(person.getAbout()) + ",\n";
            json += "\"birthYear\": " + person.getBirthYear() + "\n";    
            json +=  "}";
            resp.getOutputStream().println(json);
        }else{
            resp.getOutputStream().println("{}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String about = req.getParameter("about");
        int birthYear = Integer.parseInt(req.getParameter("birthYear"));

        DataStore.getInstance().putPerson(new Person(name, about, birthYear));
    }

}
