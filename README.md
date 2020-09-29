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
##### AWS Lambda (Generic)
##### AWS Lambda as Rest Endpoint via API Gateway
- see build.gradle
- Use of Spring Message which converts takes card of APIGatewayProxyRequestEvent and APIGatewayProxyResponseEvent
- But if you need more control over HTTP Response Codes, you can use APIGatewayProxyRequestEvent and APIGatewayProxyResponseEvent with custom Handler

### JUnit testing
* GenericImperativeFunctionTest and GatewayImperativeFunctionTest Testing covers examples of
    - Integration test with Function catalog
    - RestTemplate/WebClient - NA as application is not set up as web application
Unit test - TBD (It won't change, same until testing with mocking)

### Deploy
##### Locally - TBD
* Steps to deploy -
* Test

##### AWS Lambda (Generic)
* Package net.dilwit.springserverless.vanilla.controller.generic
* Steps to deploy (via AWS Console)
    - Create new function
    - Set Handler as 'net.dilwit.springserverless.vanilla.controller.generic.imperative.GenericHandler' which provides 'Vanilla' request/response support
    - Add Environment Variable, key -> FUNCTION_NAME, value -> function name that needs execution (ie: gatewayImperativeConsumer) OR you can create three different lambda function for each function
    - Upload .jar file
* Test
    - Go to created lambda function
    - Create test event and update FUNCTION_NAME env variable accordingly
    - Hit Test
    
##### AWS Lambda as Rest Endpoint via API Gateway (Generic)
* Package net.dilwit.springserverless.vanilla.controller.apigateway.generic
* Steps to deploy (via AWS Console)
    - Create new function
    - Set Handler as 'org.springframework.cloud.function.adapter.aws.SpringBootApiGatewayRequestHandler' which provides aws api gateway request support
    - Add Environment Variable, key -> FUNCTION_NAME, value -> function name that needs execution (ie: gatewayGenericImperativeConsumer) OR you can create three different lambda function for each function
    - Upload .jar file
    - Add 'API Gateway' as trigger
        - Select 'Create New'
        - Select 'Rest API'
        - Set security setting as 'Open'
* Test
    - Function 
        - HTTP POST
        - URL only: curl -X POST -H 'Content-Type: application/json' <aws-api-gateway-lambda-url> -d '{"name":"boo"}' -> 200 OK
        - URL with url parameters - N/A
        - To HTTP Codes () - N/A
    - Consumer 
        - HTTP POST
        - URL only: curl -X POST -H 'Content-Type: application/json' <aws-api-gateway-lambda-url>-d '{"name":"boo"}' -> 200 OK
        - URL with url parameters - N/A
        - To HTTP Codes () - N/A
    - Supplier 
        - HTTP GET
        - URL only: curl -X GET -H 'Content-Type: application/json' <aws-api-gateway-lambda-url> -> 502 (To investigate why)
        - URL with url parameters - N/A
        - URL with query parameters - N/A
        - To HTTP Codes () - N/A
        
##### AWS Lambda as Rest Endpoint via API Gateway (Specific)
* Package net.dilwit.springserverless.vanilla.controller.apigateway.specific
* Steps to deploy (via AWS Console)
    - Create new function
    - Set Handler as 'net.dilwit.springserverless.vanilla.controller.apigateway.specific.imperative.GatewaySpecificRequestResponseHandler' which provides aws api gateway request support
    - Add Environment Variable, key -> FUNCTION_NAME, value -> function name that needs execution (ie: gatewaySpecificImperativeConsumer) OR you can create three different lambda function for each function
    - Upload .jar file
    - Add 'API Gateway' as trigger
        - Select 'Create New'
        - Select 'Rest API'
        - Set security setting as 'Open'
* Test
    - Function 
        - HTTP POST
        - URL only: curl -X POST -H 'Content-Type: application/json' <aws-api-gateway-lambda-url> -d '{"name":"boo"}' -> 200 OK
        - URL with url parameters - N/A
        - To HTTP Codes () - See GatewaySpecificImperativeFunctionTest
    - Consumer 
        - HTTP POST
        - URL only: curl -X POST -H 'Content-Type: application/json' <aws-api-gateway-lambda-url>-d '{"name":"boo"}' -> 200 OK
        - URL with url parameters - TBD
        - To HTTP Codes () - See GatewaySpecificImperativeFunctionTest
    - Supplier 
        - HTTP GET
        - URL only: curl -X GET -H 'Content-Type: application/json' <aws-api-gateway-lambda-url> -> 502 (To investigate why)
        - URL with url parameters - N/A
        - URL with query parameters - N/A
        - To HTTP Codes () - See GatewaySpecificImperativeFunctionTest