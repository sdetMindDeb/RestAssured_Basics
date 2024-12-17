package APITest;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class responseSpecification {

    @Test
    void responseSpecificationTest(){
        ResponseSpecification responseSpecification=new ResponseSpecBuilder()
                .expectStatusCode(200)
                        .expectContentType("application/json")
                                .expectBody("status",equalTo("success"))
                                        .build();

        given()
                .baseUri("base uri")
                .when()
                .post("/endpoint")
                .then()
                .spec(responseSpecification)
                .log().all();
    }
}
