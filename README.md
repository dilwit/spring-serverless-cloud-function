### Standalone Web Application (With a traditional bean definition)
Focus on the master branch is to try out spring cloud functions as standalone web application

### Good reference:
https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.0.0.RELEASE/single/spring-cloud-function.html#_getting_started

### Function supported
* Function - accepts input and returns output.
* Consumer - accepts input, does not return anything .
* Supplier - does not accept input, only returns output.
* (https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.0.0.RELEASE/single/spring-cloud-function.html#_standalone_web_applications)

### Endpoints: Function as @Bean
* Function 
    - HTTP POST
    - URL only - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/functionAsBean -d '{"name":"boo"}'
    - URL with url parameters - TBD
    - Response with different HTTP Codes () - TBD
* Consumer 
    - HTTP POST
    - URL only - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/consumerAsBean -d '{"name":"boo"}'
    - URL with url parameters - TBD
    - Response with different HTTP Codes () - TBD
* Supplier 
    - HTTP GET
    - URL only - curl -X GET -H 'Content-Type: application/json' http://localhost:8080/supplierAsBean
    - URL with url parameters - TBD
    - URL with query parameters - TBD
    - Response with different HTTP Codes () - TBD

Endpoints: Function as Class
* Function 
    - HTTP POST
    - URL only - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/functionAsClass -d '{"name":"boo"}'
    - URL with url parameters - TBD
    - Response with different HTTP Codes () - TBD
* Consumer 
    - HTTP POST
    - URL only - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/consumerAsClass -d '{"name":"boo"}'
    - URL with url parameters - TBD
    - Response with different HTTP Codes () - TBD
* Supplier 
    - HTTP GET
    - URL only: curl -X GET -H 'Content-Type: application/json' http://localhost:8080/supplierAsClass
    - URL with url parameters - TBD
    - URL with query parameters - TBD
    - Response with different HTTP Codes () - TBD

### Unit/Integration testing - TBD

### Deployment 
* Local
    - Via Intellij
    - Standard .jar deployment with embedded tomcat/netty - TBD
        - gradlew clean build - creates jar
        -  