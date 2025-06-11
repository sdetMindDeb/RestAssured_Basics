package APITest.Misc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class exceptionHandling {

    @Test
    void RestAssuredExample() {
            try {
                // Make a GET request to a non-existent resource
                Response response = RestAssured.get("https://api.example.com/nonexistent");

                // Assert that the status code is 200 (this will fail and throw an exception)
                response.then().statusCode(200);

            } catch (AssertionError e) {
                // Handle the assertion error
                System.err.println("Assertion failed: " + e.getMessage());
            } catch (Exception e) {
                // Handle any other exceptions
                System.err.println("An error occurred: " + e.getMessage());
            }
    }
}
