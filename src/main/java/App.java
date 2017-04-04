import static spark.Spark.*;
import spark.route.RouteOverview;
import com.google.gson.Gson;
import net.webservicex.*;

public class App {
    public static void main(String[] args) {

        staticFiles.location("/public");

        Gson gson = new Gson();

        path("/api", () -> {
            get("/cities/:country", (request, response) -> {
                GlobalWeather ss = new GlobalWeather();
                GlobalWeatherSoap port = ss.getGlobalWeatherSoap12();  
                return port.getCitiesByCountry(request.params(":country"));
            });

            get("/json", (request, response) -> {
                return new Message("A message");
            }, gson::toJson);
        });
            
        notFound((request, response) -> {
            response.redirect("/notfound.html");
            return "";
        });

        RouteOverview.enableRouteOverview("/api");      
    }
}
