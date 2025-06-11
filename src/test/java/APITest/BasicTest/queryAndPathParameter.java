package APITest.BasicTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class queryAndPathParameter {

    @Test
    void queryAndPathParameters(){

        //https://reqres.in/api/users?page=2
            given()
            .pathParam("mypath","users")
                    //We can add multiple path parameter as well.
                    .queryParam("page",2)
                    .when()
                    .get("https://reqres.in/api/{mypath}")
                    .then()
                    .statusCode(200)
                    .body("page",equalTo(2))
                    .log().all();
        }
    }