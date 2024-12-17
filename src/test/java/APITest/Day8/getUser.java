package APITest.Day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUser {

    @Test
    void getUserTest(ITestContext context){

        int id =(Integer) context.getAttribute("user_id");

        //To get the variable in suite level(testng.xml)
        //int id=(Integer) context.getSuite().getAttribute("user_id_suite");
        String Token="Token";

        given()
                .header("Authorization","Bearer "+Token)
                .pathParam("id",id)
                .when()
                .get("hostname/{id}")
                .then()
                .statusCode(200)
                .log()
                .all();

    }
}
