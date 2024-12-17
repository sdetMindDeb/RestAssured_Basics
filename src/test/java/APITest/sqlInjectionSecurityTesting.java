package APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class sqlInjectionSecurityTesting {

    /*SQL injection testing in APIs involves checking if the API is vulnerable to SQL injection attacks,
     where malicious SQL code is inserted into a query to manipulate the database.
     Here's a brief overview and how you can perform this testing using Rest Assured:*/

    /*SQL injection testing aims to identify vulnerabilities where an attacker can execute arbitrary SQL code.
     This can lead to unauthorized data access, data modification, or even deletion.*/

    @Test
    void sqlInjectionTestingSample(){
        // Base URI of the API
        RestAssured.baseURI = "https://api.example.com";

        // Malicious input
        String maliciousInput = "' OR '1'='1";

        // Sending the request
        Response response = given()
                .param("username", maliciousInput)
                .param("password", "password")
                .when()
                .get("/login")
                .then()
                .extract().response();

        // Validate the response
        if (response.getStatusCode() == 200 && response.getBody().asString().contains("Welcome")) {
            System.out.println("Potential SQL Injection vulnerability detected!");
        } else {
            System.out.println("No SQL Injection vulnerability detected.");
        }
    }
}
