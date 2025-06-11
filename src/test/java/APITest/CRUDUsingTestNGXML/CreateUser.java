package APITest.CRUDUsingTestNGXML;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    void createUserTest(ITestContext context){
        Faker faker=new Faker();

        JSONObject data=new JSONObject();
        data.put("name", faker.name().fullName());
        data.put("gender","male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");

        String Token="Token";

        Response res=given().
                header("Authorization","Bearer "+Token)
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("post url");

        int id=res.jsonPath().getInt("id");
        context.setAttribute("user_id",id);

        //To get access in suite level
        context.getSuite().setAttribute("user_id_Suite",id);


    }
}
