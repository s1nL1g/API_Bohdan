package studyPackAPI;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserPositive {

    @Test
    public void get10thUserPositive() {
        ValidatableResponse response = given()
                        .filter(new AllureRestAssured())
                        .baseUri("https://reqres.in/")
                .when()
                        .get("api/users/10")
                .then()
                        .statusCode(200)
                        .body("data.id", equalTo(10))
                        .body("data.last_name", containsString("Fields"))
                        .body("data.first_name", containsString("Byron"))
                        .body("data.email", containsString("byron.fields@reqres.in"));

    }
}

