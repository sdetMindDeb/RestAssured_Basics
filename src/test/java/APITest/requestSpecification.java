package APITest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class requestSpecification {

    @Test
    void requestSpecificationTest(){
        RequestSpecification requestSpecification= RestAssured.given()
                .baseUri("Uri")
                .header("content-Type","application/json")
                .header("Authorization","BearerToken here");

        given()
                .spec(requestSpecification)
                .when()
                .post("/endpoint")
                .then()
                .assertThat().statusCode(200);
    }
}
