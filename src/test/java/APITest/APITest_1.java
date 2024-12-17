package APITest;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest_1 {

    private int id;

    @Test(priority = 1)
    void getUser(){
        given().
                when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();

    }

    @Test(priority = 2)
    void createUser(){
        HashMap data=new HashMap();
        data.put("name","Debdip");
        data.put("job","QA");

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

    @Test(priority = 3,dependsOnMethods = ("createUser"))
    void updateUser(){
        HashMap data=new HashMap();
        data.put("name","Debdip1");
        data.put("job","QA-test");

        given()
                .contentType("application/json")
                .body(data).
                when()
                .post("https://reqres.in/api/users"+id)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(priority = 4,dependsOnMethods = ("createUser"))
    void deleteUser(){
        given().
                when()
                .delete("https://reqres.in/api/users"+id)
                .then()
                .statusCode(204)
                .log().all();
    }
}
