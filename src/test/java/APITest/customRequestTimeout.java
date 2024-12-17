package APITest;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

public class customRequestTimeout {

    public void customeRequestTimeout() {
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 5000) // Connection timeout
                        .setParam("http.socket.timeout", 5000)); // Socket timeout

        RestAssured.given()
                .config(config)
                .when()
                .get("https://yourapi.com/endpoint")
                .then()
                .statusCode(200);
    }
}
