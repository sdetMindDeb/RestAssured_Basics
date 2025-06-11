package APITest.Misc.SecurityTesting;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;

public class XSSAttackStringValidation {

    //Send payload that include XSS attack string and validate the API response to ensure
    //it is properly sanitised.

    /*This is part of security testing.*/

    @Test
    public void testXSSAttackString() {
        String xssPayload = "<script>alert('XSS');</script>";
        Response response = given()
                .contentType("application/json")
                .body("{\"input\":\"" + xssPayload + "\"}")
                .when()
                .post("https://yourapi.com/endpoint")
                .then()
                .statusCode(200)
                .extract().response();

        // Validate the response
        String responseBody = response.getBody().asString();
        assertThat(responseBody, not(containsString(xssPayload)));
    }
}
