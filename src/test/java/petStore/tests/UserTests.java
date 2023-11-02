package petStore.tests;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;
import petStore.pojo.builders.UserRequestBuilder;
import petStore.pojo.userDTO.PostUserResponse;
import petStore.pojo.userDTO.UserGetResponse;
import petStore.spec.Specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserTests {

    @Test
    @Description("Create user on platform")
    public void postUser() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        UserRequestBuilder newUser = UserRequestBuilder.builder().build();

        PostUserResponse response = given()
                .filter(new AllureRestAssured())
                .body(newUser)
            .when()
                .post("/user")
            .then()
                .extract().as(PostUserResponse.class);

        assertEquals(response.getType(), "unknown");
    }

    @Test
    @Description("Get user by Name")
    public void getUserString() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        UserGetResponse response = given()
                .filter(new AllureRestAssured())
                .when()
                .get("/user/string")
                .then().log().body()
                .extract().as(UserGetResponse.class);

        assertEquals(Optional.ofNullable(response.getUserStatus()), 0);
        assertEquals(response.getUsername(), "string");
    }

    @Test
    @Description("Posting the users using the array")
    public void postUsersWithArray() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        UserRequestBuilder builderNum1 = UserRequestBuilder.builder().build();
        UserRequestBuilder builderNum2 = UserRequestBuilder.builder().build();

        List<UserRequestBuilder> arrayBuilder = new ArrayList<>();
        arrayBuilder.add(builderNum1);
        arrayBuilder.add(builderNum2);

        PostUserResponse response = given()
                .filter(new AllureRestAssured())
                .when()
                .body(arrayBuilder)
                .post("/user/createWithArray")
                .then().log().body()
                .extract().as(PostUserResponse.class);

        assertEquals(response.getMessage(), "ok");
    }
}
