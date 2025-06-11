package APITest.Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class authentications {

    //Basic Authentications using username and password
    @Test
    void testBasicAuthentications() {
        given()
                .auth().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    //Digest Authentication
    //Basic and Digest Authentication is same, but internal algorithm is different
    @Test
    void testDigestAuthentications() {
        given()
                .auth().digest("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    //Preemptive Authentication
    //Basic and Preemptive Authentication is same, but internal algorithm is different
    //Preemptive is like combination of basic and digest
    @Test
    void testPreEmptiveAuthentications() {
        given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    //Bearer Token Authentications
    @Test
    void testBearerTokenAuthentications() {

        String bearerToken = "Token";

        given()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }

    //oAuth 1.0
    //oAuth 1.0 Authentications
    @Test
    void testAuthOneAuthentications() {

        String bearerToken = "Token";

        given()
                .auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }

    //oAuth 2.0
    //oAuth 2.0 Authentications---This is advanced version of oAuth1.0 authentication.Here only Token is required.
    @Test
    void testAuthTwoAuthentications() {
        given()
                .auth().oauth2("OauthToken2")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }

    //API Key Authentication
    //This example is as per shown in video. The API key and value is sent as part of query parameter.This ia as specified.
    //This will change as per specified in software release
    @Test
    void testAPIKeyAuthentications() {
        given()
                .queryParam("apiID", "APIID value")//API ID is api key
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }
}