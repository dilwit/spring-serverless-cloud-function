### Good reference:
https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.0.0.RELEASE/single/spring-cloud-function.html#_getting_started

### Function supported
* Function - accepts input and returns output.
* Consumer - accepts input, does not return anything .
* Supplier - does not accept input, only returns output.
* (https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.0.0.RELEASE/single/spring-cloud-function.html#_standalone_web_applications)

### Endpoints: Function as @Bean
* Function - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/functionAsBean -d '{"name":"boo"}'
* Consumer - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/consumerAsBean -d '{"name":"boo"}'
* Supplier - curl -X GET -H 'Content-Type: application/json' http://localhost:8080/supplierAsBean

### Endpoints: Function as Class
* Function - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/functionAsClass -d '{"name":"boo"}'
* Consumer - curl -X POST -H 'Content-Type: application/json' http://localhost:8080/consumerAsClass -d '{"name":"boo"}'
* Supplier - curl -X GET -H 'Content-Type: application/json' http://localhost:8080/supplierAsClass
