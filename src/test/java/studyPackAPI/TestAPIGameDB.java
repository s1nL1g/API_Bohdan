package studyPackAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import studyPackAPI.pojoFiles.RequestOrder;
import studyPackAPI.pojoFiles.ResponseOrder;
import studyPackAPI.pojoFiles.ResponseOrderGet;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TestAPIGameDB {

    @Test
    public void checkGetGames() {
        Response response = given()
                .baseUri("http://localhost:8080")
                .header("Accept", "application/json")
                .when()
                .get("/app/videogames/1");

        ResponseOrderGet responseOrderGet = response.as(ResponseOrderGet.class);

        assertEquals(responseOrderGet.id, 1);
        assertEquals(responseOrderGet.name, "Resident Evil 4");
        assertEquals(responseOrderGet.releaseDate, "2005-10-01");
        assertEquals(responseOrderGet.reviewScore, 85);
        assertEquals(responseOrderGet.category, "Shooter");
        assertEquals(responseOrderGet.rating, "Universal");

        System.out.println(response.prettyPrint());
    }

    @Test
    public void checkPostGames() {
        RequestOrder requestOrder = new RequestOrder(12, "Rainbow 6 Siege", "2015", 1488, "FPS", "12/10");

        ResponseOrder responseOrder = given()
                .baseUri("http://localhost:8080")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestOrder)
                .when()
                .post("/app/videogames")
                .then()
                .statusCode(200).extract().as(ResponseOrder.class);

        assertEquals(responseOrder.getStatus(), "Record Added Successfully");
    }

    @Test
    public void checkDeleteGames() {
        Response response = given()
                .baseUri("http://localhost:8080")
                .header("Accept", "application/json")
                .when()
                .delete("/app/videogames/11");

        System.out.println(response.prettyPrint());
        assertEquals(response.getStatusCode(), 200, "Status code does not equal match.");
    }

    @Test
    public void checkPutGames() {
        RequestOrder update = new RequestOrder(5, "The Legend of Zelda: Ocarina of Time XII",
                "1998-12-10", 80, "Adventure", "PG-13");

        ResponseOrder response = given()
                .baseUri("http://localhost:8080")
                .header("Accept", "application/json")
                .body(update)
                .when()
                .put("/app/videogames/5")
                .then().statusCode(200).extract().as(ResponseOrder.class);

        assertEquals(response.getStatus(), "The Legend of Zelda: Ocarina of Time XII");
    }
}
