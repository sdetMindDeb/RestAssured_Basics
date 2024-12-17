package APITest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class versionValidation {

    //we can add version details in headers or url

    @Test
    void validateVersion() {
        String version="v1";
        given()
                .header("API-Version",version)
                .when()
                .get("url"+version+"/resource")//just for example
                .then()
                .statusCode(200)
                .log().all();
    }
}
