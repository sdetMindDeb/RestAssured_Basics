package APITest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CookiesInRequest {

    @Test
    void cookiesInReq(){

        given()
                .cookie("sessionid","hfbshdbfhb")
                .when()
                .post("url")
                .then()
                .assertThat().statusCode(200);
    }
}
