### AWS Lambda support with Spring Cloud Function
- AWS Lambda (Generic)
- AWS Lambda as Rest Endpoint via API Gateway

### Good reference:
https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.0.0.RELEASE/single/spring-cloud-function.html#_getting_started
https://cloud.spring.io/spring-cloud-function/reference/html/spring-cloud-function.html#_introduction
https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.1.1.RELEASE/aws.html

### Function supported
* Function - accepts input and returns output.
* Consumer - accepts input, does not return anything .
* Supplier - does not accept input, only returns output.
* (https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.0.0.RELEASE/single/spring-cloud-function.html#_standalone_web_applications)

### Endpoints: Function as @Bean
N/A

    
### Notable code level changes to make aws-lambda ready
##### AWS Lambda (Generic) - TBD
##### AWS Lambda as Rest Endpoint via API Gateway
- see build.gradle
- use of Spring Message which converts takes card of APIGatewayProxyRequestEvent and APIGatewayProxyResponseEvent

### JUnit testing - TBD

### Deploy
##### Locally - TBD
* Steps to deploy
* Test
##### AWS Lambda (Generic)
* Steps to deploy (via AWS Console)
    - Create new function
    - Set Handler as 'net.dilwit.springserverless.vanilla.controller.generic.GenericHandler' which provides 'Vanilla' request/response support
    - Add Environment Variable, key -> FUNCTION_NAME, value -> function name that needs execution (ie: gatewayImperativeConsumer) OR you can create three different lambda function for each function
    - Upload .jar file
* Test
    - Go to created lambda function
    - Create test event and update FUNCTION_NAME env variable accordingly
    - Hit Test
##### AWS Lambda as Rest Endpoint via API Gateway
* Steps to deploy (via AWS Console)
    - Create new function
    - Set Handler as 'org.springframework.cloud.function.adapter.aws.SpringBootApiGatewayRequestHandler' which provides aws api gateway request support
    - Add Environment Variable, key -> FUNCTION_NAME, value -> function name that needs execution (ie: genericImperativeConsumer) OR you can create three different lambda function for each function
    - Upload .jar file
    - Add 'API Gateway' as trigger
        - Select 'Create New'
        - Select 'Rest API'
        - Set security setting as 'Open'
* Test
    - Function 
        - HTTP POST
        - URL only: curl -X POST -H 'Content-Type: application/json' <aws-api-gateway-lambda-url> -d '{"name":"boo"}' -> 200 OK
        - URL with url parameters - TBD
        - To HTTP Codes () - TBD
    - Consumer 
        - HTTP POST
        - URL only: curl -X POST -H 'Content-Type: application/json' <aws-api-gateway-lambda-url>-d '{"name":"boo"}' -> 200 OK
        - URL with url parameters - TBD
        - To HTTP Codes () - TBD
    - Supplier 
        - HTTP GET
        - URL only: curl -X GET -H 'Content-Type: application/json' <aws-api-gateway-lambda-url> -> 502 (To investigate why)
        - URL with url parameters - TBD
        - URL with query parameters - TBD
        - To HTTP Codes () - TBD
        