package APITest.Day6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class jsonSchemaValidator {

//We will be validating the data type of each field with schema validation
    //We will take response of API and use one website to convert response to json schema
    //https://jsonformatter.org/json-to-jsonschema
    //json response(.json)-->json schema(.json)

    @Test
    void jsonSchemaValidation(){

        //https://reqres.in/api/users?page=2
        given()
                .pathParam("mypath","users")
                .queryParam("page",2)
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));

    }
}
