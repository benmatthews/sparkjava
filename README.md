# Sparkjava

How to create a executable jar containing a jetty based REST resource in 10 mins.


## Create an app

1. Install sdkman with ```curl -s "https://get.sdkman.io" | bash ```
2. Install gradle with ```sdk install gradle```
3. Create an app folder 
```
mkdir app
cd app
```
4. Init a gradle java application ```gradle init --type java-application```
5. Build the app ```./gradlew buid```
6. Run the app ```./gradlew run```

## Create rest resource with sparkjava

1. Add the sparkjava dependency ```compile "com.sparkjava:spark-core:2.5.5"```
2. Create a basic app in ```src/main/java/App.java```
```
public class App {
    public static void main(String[] args) {
        path("/api", () -> {
            get("/hello-world", (req, res) -> {
            });
        });
    }
}
```
3. Test it by running ```./gradlew run``` and open browser on ```http://localhost:4567/api/hello-world```

## Create a executable jar

1. Add the shadow gradle plugin ```https://github.com/johnrengelman/shadow```
2. Build the app ```./gradlew buid```
3. Run the jar ```java -jar build/libs/<appnam>-all.jar```
4. Test it by opening a browser on ```http://localhost:4567/api/hello-world```

## To generate a soap client

1. Download apache cxf ``` curl http://www-eu.apache.org/dist/cxf/3.1.10/apache-cxf-3.1.10.zip```
2. Extract the wsdl2java binary and add it to your path
3. Generate the java code from ```wsdl2java -client http://www.webservicex.com/globalweather.asmx?WSDL```
4. Include the generated code in your project and call the web service e.g.
```
GlobalWeather ss = new GlobalWeather();
GlobalWeatherSoap port = ss.getGlobalWeatherSoap12();  
return port.getCitiesByCountry("Norway");
```

### Useful gradle commands
```
./gradlew -h
./gradlew tasks
./gradlew build
./gradlew run
```

### Improvements

1. Download the wsdl and generate a soap client with gradle e.g. ```https://github.com/nilsmagnus/wsdl2java```
2. Add validation
3. Add environment properties
4. Add service scripts

