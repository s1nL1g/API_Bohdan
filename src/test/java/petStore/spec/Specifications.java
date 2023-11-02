package petStore.spec;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Step("Setting base url and and setting the JSON content type")
    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step("Setting base url and and setting the MULTIPART content type")
    public static RequestSpecification requestSpecificationFile(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.MULTIPART)
                .build();
    }

    @Step("Build response specifications with expecting status code")
    public static ResponseSpecification responseSpecification(Integer code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }

    @Step("Setup specs for request and response")
    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
