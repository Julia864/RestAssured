import entities.Pet;
import entities.User;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.CommonService;

import java.util.List;
import static io.restassured.RestAssured.given;

public class TestOne {
    private final static String URL = "https://petstore.swagger.io/v2";


    @Test
    public void getPetByStatusPending() {
        CommonService.installSpecification(CommonService.requestSpec(URL), CommonService.responseSpec(200));

        List<Pet> pets = given()
                .when()
                .get("/pet/findByStatus?status=pending")
                .then().log().all()
                .extract().body().jsonPath().getList("",Pet.class);
        pets.forEach(x -> Assert.assertTrue(x.getStatus().contains("pending")));

    }

    @Test
    public void getPetByID() {
        CommonService.installSpecification(CommonService.requestSpec(URL), CommonService.responseSpec(200));

        List<Pet> pets = given()
                .when()
                .get("/pet/2")
                .then().log().all()
                .extract().body().jsonPath().getList("data",Pet.class);
                pets.forEach(x -> Assert.assertEquals(x.getId(), "2"));
    }

    @Test
    public void deletePet() {

        CommonService.installSpecification(CommonService.requestSpec(URL), CommonService.responseSpec(200));
        RestAssured.given()
                .when()
                .delete("/pet/9")
                .then().log().all()
                        .assertThat().statusCode(200);
    }


    @Test

    public void postUser() {
        CommonService.installSpecification(CommonService.requestSpec(URL), CommonService.responseSpec(200));

        User user = new User(77, "esssee", "Julia", "Jphns", "dfndjf@fkfer.fe", "dfdfd", "gregre", 200);
        RestAssured.given()
                .body(user)
                .post("/user")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
