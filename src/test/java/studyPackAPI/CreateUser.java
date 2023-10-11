package studyPackAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void createUserPositive() {
        Response response = given()
                .baseUri("https://reqres.in/")
                .header("Accept","application/json")
        .when()
                .get("/api/users/2");

    }
}
