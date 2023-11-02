package petStore.tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import petStore.pojo.builders.StoreRequestBuilder;
import petStore.pojo.storeDTO.GetStoreResponse;
import petStore.pojo.storeDTO.StorePostResponse;
import petStore.spec.Specifications;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class StoreTests {

    @Test
    @Description("Making the order")
    public void postOrder() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        StoreRequestBuilder newOrder = StoreRequestBuilder.builder().build();

        StorePostResponse response = given()
                .body(newOrder)
                .when()
                .post("/store/order")
                .then().log().body()
                .extract().as(StorePostResponse.class);

        assertEquals(response.getStatus(), "placed");
        assertEquals(response.getComplete().booleanValue(), true);
    }

    @Test
    @Description("Get orders by ID")
    public void getOrderId() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        GetStoreResponse response = given()
                .when()
                .post("/store/order/7")
                .then().log().body()
                .extract().as(GetStoreResponse.class);

        assertEquals(Optional.ofNullable(response.getId()), 7);
        assertEquals(response.getComplete().booleanValue(), true);
    }
}
