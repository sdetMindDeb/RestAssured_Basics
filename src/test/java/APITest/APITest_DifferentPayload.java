package APITest;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//1. Through HashMap
//2. Through Jason.org library
//3. Using POJO Class
//4. External JSON File

public class APITest_DifferentPayload {

    private int id;

    //Using HashMap
    //@Test(priority = 1)
    void createUserUsingHashMap(){
        HashMap data=new HashMap();
        data.put("name","Debdip");
        data.put("job","QA");

        /*If in case we need to use array
        String courses[]={"Java","c++"};
        data.put("course",courses);*/

        id=given()
                .contentType("application/json")
                .body(data).
                when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
                /*.then()
                .statusCode(201)
                .log().all();*/
    }

    //Using JSONLibrary
    //@Test(priority = 2)
    void createUserUsingJsonLibrary(){
        JSONObject data=new JSONObject();

        data.put("name","Debdip");
        data.put("job","QA");

        /*If in case we need to use array
        String courses[]={"Java","c++"};
        data.put("course",courses);*/

        id=given()
                .contentType("application/json")
                .body(data.toString()).
                when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
                /*.then()
                .statusCode(201)
                .log().all();*/
    }

    //Using POJO
    //@Test(priority = 3)
    void createUserUsingPOJO(){
        POJO_PayloadBody PJ=new POJO_PayloadBody();

        PJ.setJob("Trainee");
        PJ.setName("Tester");

        id=given()
                .contentType("application/json")
                .body(PJ).
                when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
                /*.then()
                .statusCode(201)
                .log().all();*/
    }

    //Using External json
    @Test(priority = 1)
    void createUserUsingExternalJson() throws FileNotFoundException {
        File f=new File(".\\Body.json");
        FileReader fr=new FileReader(f);
        JSONTokener jt=new JSONTokener(fr);
        JSONObject data=new JSONObject(jt);

        id=given()
                .contentType("application/json")
                .body(data.toString()).
                when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
                /*.then()
                .statusCode(201)
                .log().all();*/
    }

    @Test(priority = 2/*,dependsOnMethods = ("createUserUsingHashMap")*/)
    void deleteUser(){
        given().
                when()
                .delete("https://reqres.in/api/users"+id)
                .then()
                .statusCode(204)
                .log().all();
    }
}
