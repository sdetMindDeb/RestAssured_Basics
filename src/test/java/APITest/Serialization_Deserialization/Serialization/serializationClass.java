package APITest.Serialization_Deserialization.Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class serializationClass {

    //It means converting a JAVA object(POJO) into JSON Object so that it can be sent as part of the request body

    //Suppose we have to create below jSON Object using POJO class
    /*{
        "id": 1,
        "name": "John Doe",
        "email":"johndoe@example.com",
        "age": "30",
        "isActive": "true",
        "hobbies": [
            "reading",
            "travelling",
            "swimming"
        ],
        "addressDetails": {
            "city": "New York",
            "state": "NY",
            "street": "123 Main St",
            "zip": "10001"
        }
    }*/

    @Test
    void serializations() throws JsonProcessingException{
        Addressdetails ad= new Addressdetails("New York", "NY", "123 Main St", "10001");
        List<String> hobbies=new ArrayList<>();
        hobbies.add("reading");
        hobbies.add("travelling");
        hobbies.add("swimming");

        profileDetails pfd=new profileDetails(1,"john doe","johndoe@example.com", "30", "true", hobbies, ad);
        //We can use ObjectMapper class to convert POJO to JSON Object
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pfd);
        System.out.println(requestBody);

        //We can use this requestBody in our API request

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("url") // Replace with your actual URL
                .then()
                .statusCode(201) // Assuming 201 is the expected status code for successful creation
                .log().all();
    }
}
