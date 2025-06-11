package APITest.CRUDUsingTestNGXML;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class updateUser {

    @Test
    void updateUserTest(ITestContext context){
        int id =(Integer) context.getAttribute("user_id");

        //To get the variable in suite level(testng.xml)
        //int id=(Integer) context.getSuite().getAttribute("user_id_suite");

        Faker faker=new Faker();

        JSONObject data=new JSONObject();
        data.put("name", faker.name().fullName());
        data.put("gender","male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","active");

        String Token="Token";

        given().
                header("Authorization","Bearer "+Token)
                .contentType("application/json")
                .body(data.toString())
                .pathParam("id",id)
                .when()
                .put("url/{id}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
