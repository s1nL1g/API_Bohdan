package studyPackAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import studyPackAPI.pojoFiles.SingleUserInfoResponseDTO;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class GetSingleUserPositive {

    @Test
    public void get10thUserPositive() {
        Response response = given()
                .baseUri("https://reqres.in/")
        .when()
                .get("api/users/10");

        SingleUserInfoResponseDTO root = response.as(SingleUserInfoResponseDTO.class);

        assertTrue(root.data.id == 10);
        assertTrue(root.data.last_name.contains("Fields"));
        assertTrue(root.data.first_name.contains("Byron"));
        assertTrue(root.data.email.contains("byron.fields@reqres.in"));
    }
}
