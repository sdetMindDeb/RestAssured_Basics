package APITest.Validation;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class headerValidation {

    @Test
    void getHeaders() {

        given()
                .when()
                .get("https://www.google.co.in/")
                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .header("Content-Encoding","gzip")
                .header("Server","gws")
                .log().all();
        }

    @Test
    void getHeaderValues() {

        Response Res=given()
                .when()
                .get("https://www.google.co.in/");

        //get Single header Value
        String headervalue= Res.getHeader("Content-Type");
        System.out.println(headervalue);

        //get Multiple header values
        Headers hd=Res.getHeaders();
        for(Header header:hd){
            System.out.println(header.getName()+" value is "+header.getValue());
        }
    }
}
