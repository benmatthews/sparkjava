import static spark.Spark.*;
import net.webservicex.*;

public class App {
    public static void main(String[] args) {
        path("/api", () -> {
            
            get("/hello", (req, res) -> {
                GlobalWeather ss = new GlobalWeather();
                GlobalWeatherSoap port = ss.getGlobalWeatherSoap12();  
                return port.getCitiesByCountry("Norway");
            });
        });
    }
}
