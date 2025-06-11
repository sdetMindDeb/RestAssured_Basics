package APITest.Validation.CookieValidation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class cookiesValidation {

    @Test
    void getCookies()
    {
        Response res=given()
                .when()
                .get("https://www.google.co.in/");

        //getSingleCookie

        String cookie_value=res.getCookie("AEC");
        System.out.println("Value of the cookie----->"+cookie_value);

        //get Multiple Cookie

        Map<String,String> cookie_values=res.getCookies();

        System.out.println(cookie_values.keySet());

        for(String k:cookie_values.keySet()){
            String cookieValue=res.getCookie(k);
            System.out.println(k+"---Cookie value--->"+cookieValue);
        }

        //Another way of printing Hashmap
        System.out.println("Cookies are: " + cookie_values);
        Iterator it= cookie_values.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
