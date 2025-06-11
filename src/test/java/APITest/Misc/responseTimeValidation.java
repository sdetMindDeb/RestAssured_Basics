package APITest.Misc;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

import static io.restassured.RestAssured.given;

public class responseTimeValidation {

    @Test
    void requestSpecificationTest(){

        Response res=given()
                .when()
                .post("/endpoint");

        res.then()
                .time(lessThan(2000L));//less than 2 sec

        //alternate
        res.then().time(lessThan(2L), TimeUnit.SECONDS);

        //To catch exact time taken

        long responseTimeInUnit=res.timeIn(TimeUnit.SECONDS);
        System.out.println("Response time"+responseTimeInUnit);

    }
}
