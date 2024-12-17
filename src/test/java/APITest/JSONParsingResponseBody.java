package APITest;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JSONParsingResponseBody {

    @Test(priority = 1)
    void testJsonResponse(){
        //Approach 1
        given()
                .contentType("ContentType.JSON")
                .when()
                .get("GivetheUrl")
                .then()
                .statusCode(200)
                .header("Content-Type","text/html; charset=ISO-8859-1")//sample
                .body("book[3].title",equalTo("Test of the cents"));

    }

    @Test(priority = 2)
    void testJsonResponseSecApproach(){
        //Approach 2
        Response res=
        given()
                .contentType("ContentType.JSON")
                .when()
                .get("GivetheUrl");

        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"text/html; charset=ISO-8859-1");

        String bookName=res.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(bookName,"Test of the cents");
    }

    @Test(priority = 3)
    void printAllBookTitles(){
        //Approach 2
        Response res=
                given()
                        .contentType("ContentType.JSON")
                        .when()
                        .get("GivetheUrl");

        JSONObject jo=new JSONObject(res.toString());//converting response to json object type
        for(int i=0;i<jo.getJSONArray("book").length();i++){
            String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            System.out.println(bookTitle);
        }
    }

    @Test(priority = 4)
    void checkBookTitlePresentOrNot(){
        boolean status=false;
        //Approach 2
        Response res=
                given()
                        .contentType("ContentType.JSON")
                        .when()
                        .get("GivetheUrl");

        JSONObject jo=new JSONObject(res.toString());//converting response to json object type
        for(int i=0;i<jo.getJSONArray("book").length();i++){
            String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            if(bookTitle.equals("Test of the cents"))
            {
                status=true;
                break;
            }
        }
        Assert.assertEquals(status,true);
    }

    @Test(priority = 4)
    void calculateTotalPriceOfBook(){
        double totalPrice=0;
        //Approach 2
        Response res=
                given()
                        .contentType("ContentType.JSON")
                        .when()
                        .get("GivetheUrl");

        JSONObject jo=new JSONObject(res.toString());//converting response to json object type
        for(int i=0;i<jo.getJSONArray("book").length();i++){
            String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
            totalPrice=totalPrice+Double.parseDouble(price);
        }
        System.out.println("Total book price:"+totalPrice);
        Assert.assertEquals(totalPrice,320.46);
    }

    @Test(priority = 5)
    void hasKey(){
                given()
                        .contentType("ContentType.JSON")
                        .when()
                        .get("GivetheUrl")
                        .then()
                        .body("book[0]", Matchers.hasKey("category"));
    }
}


/*
Sample JSON Response

{
"book":[
        {
        "author":"ABC",
        "category":"Test",
        "Price":120.90,
        "title":"Narach"
        },
        {
        "author":"DEF",
        "category":"Test1",
        "Price":128.70,
        "title":"Good Eye"
        },
        {
        "author":"GHI",
        "category":"Test2",
        "Price":70.86,
        "title":"Test of the cents"
        }
]}
*/