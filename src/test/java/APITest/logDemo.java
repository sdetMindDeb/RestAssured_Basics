package APITest;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class logDemo {

    @Test(priority = 1)
    void logAll(){
        given()
                .when()
                .get("https://www.google.co.in/")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    void logHeader(){
        given()
                .when()
                .get("https://www.google.co.in/")
                .then()
                .statusCode(200)
                .log().headers();
    }

    @Test(priority = 3)
    void logCookie(){
        given()
                .when()
                .get("https://www.google.co.in/")
                .then()
                .statusCode(200)
                .log().cookies();
    }

    @Test(priority = 4)
    void logBody(){
        given()
                .when()
                .get("https://www.google.co.in/")
                .then()
                .statusCode(200)
                .log().body();
    }
}
