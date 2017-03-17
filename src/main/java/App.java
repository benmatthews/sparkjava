import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        path("/api", () -> {
            get("/hello", (req, res) -> {
                return "Hello World";
            });
            get("/goodbye", (req, res) -> {
                return "Goodbye World";
            });
        });
    };
}