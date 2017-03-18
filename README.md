# Sparkajava

- curl -s "https://get.sdkman.io" | bash
- sdk install gradle
- mkdir app
- cd app
- gradle init --type java-application 
- ./gradlew buid
- ./gradlew run
- download apache cxf - http://www-eu.apache.org/dist/cxf/3.1.10/apache-cxf-3.1.10.zip
    extract the wsdl2java binary and add it to your path
- generate the java code from - wsdl2java -client http://www.webservicex.com/globalweather.asmx?WSDL
- Add the shadow jar plugin to create executable jar file.

