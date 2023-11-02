package petStore.tests;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;
import petStore.pojo.builders.PetRequestBuilder;
import petStore.pojo.petDTO.GetPetResponse;
import petStore.pojo.petDTO.PetAddingResponse;
import petStore.pojo.petDTO.PetStoreResponse;
import petStore.spec.Specifications;

import java.io.File;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PetTests {

    @Test
    @Description("Adding some pet to shop")
    public void addPetToShop() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        PetRequestBuilder newPet = PetRequestBuilder.builder().build();

        PetAddingResponse response = given()
                .filter(new AllureRestAssured())
                .body(newPet)
                .when()
                .post("/pet")
                .then().log().body()
                .extract().as(PetAddingResponse.class);

        assertEquals(response.getStatus(), "adopted");
        assertEquals(response.getName(), "nigga");
    }

    @Test
    @Description("Update info about pet")
    public void updatePetInfo() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        PetRequestBuilder updatePet = PetRequestBuilder.builder().build();

        PetAddingResponse response = given()
                .filter(new AllureRestAssured())
                .body(updatePet)
                .when()
                .put("/pet")
                .then().log().body()
                .extract().as(PetAddingResponse.class);

        assertEquals(response.getStatus(), "adopted");
        assertEquals(response.getName(), "niger");
    }

    @Test
    @Description("Set image for pet")
    public void uploadPetsImage() {
        Specifications.installSpecification(Specifications.requestSpecificationFile(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        File downloadedIcon = new File("/Users/admin/Downloads/image.jpeg");

        PetStoreResponse response = given()
                .filter(new AllureRestAssured())
                .multiPart(downloadedIcon)
                .when()
                .post("/pet/7/uploadImage")
                .then().log().body()
                .extract().as(PetStoreResponse.class);

        assertEquals(response.getType(), "unknown");
    }

    @Test
    @Description("Search the pet by him id")
    public void findPetById() {
        Specifications.installSpecification(Specifications.requestSpecification(Specifications.BASE_URL),
                Specifications.responseSpecification(200));

        GetPetResponse response = given()
                .filter(new AllureRestAssured())
                .when()
                .get("/pet/7")
                .then().log().body()
                .extract().as(GetPetResponse.class);

        assertEquals(Optional.ofNullable(response.getId()), 7);
        assertEquals(response.getStatus(), "adopted");
        assertEquals(response.getName(), "niger");
    }
}
