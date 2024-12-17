package APITest;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class parsingXmlResponse {

    @Test(priority = 1)
    void testXmlResponse(){
        given()
                .when()
                .get("ABC")
                .then()
                .statusCode(200)
                .header("Content-Type","application/xml; charset=utf-8")
                .body("TravelerinformationResponse.page",equalTo("1"))//Sample from video
                .body("response.data.books.book[0].author",equalTo("F. Scott Fitzgerald"))//from down xml response
                ;
    }

    @Test(priority = 2)
    void testXmlResponseApproach2(){
        //Approach 2
        Response res=given()
                .when()
                .get("ABC");

        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");

        String pageNumber=res.xmlPath().get("TravelerinformationResponse.page").toString();
        Assert.assertEquals(pageNumber,equalTo("1"));

        String authorName=res.xmlPath().get("response.data.books.book[0].author").toString();
        Assert.assertEquals(authorName,equalTo("F. Scott Fitzgerald"));
    }

    @Test(priority = 3)
    void verifyNumberOfBooks(){
        Response res=given()
                .when()
                .get("ABC");

        XmlPath xmlobj=new XmlPath(res.asString());

        List<String> listOfBooks=xmlobj.getList("response.data.books.book");
        Assert.assertEquals(listOfBooks.size(),3);
    }

    @Test(priority = 4)
    void verifyBookIsPresent(){
        Response res=given()
                .when()
                .get("ABC");

        XmlPath xmlobj=new XmlPath(res.asString());

        List<String> book_list=xmlobj.getList("response.data.books.book.title");

        boolean isPresent=false;

        for(String bookTitle:book_list){
            if(bookTitle.equals("To Kill a Mockingbird")){
                isPresent=true;
                break;
            }
        }

        Assert.assertEquals(isPresent,true);
    }
}

/*Sample XML response
<?xml version="1.0" encoding="UTF-8"?>
<response>
    <status>success</status>
    <data>
        <books>
            <book>
                <title>The Great Gatsby</title>
                <author>F. Scott Fitzgerald</author>
                <publication_year>1925</publication_year>
                <isbn>9780743273565</isbn>
                <price>10.99</price>
            </book>
            <book>
                <title>To Kill a Mockingbird</title>
                <author>Harper Lee</author>
                <publication_year>1960</publication_year>
                <isbn>9780061120084</isbn>
                <price>7.99</price>
            </book>
            <book>
                <title>1984</title>
                <author>George Orwell</author>
                <publication_year>1949</publication_year>
                <isbn>9780451524935</isbn>
                <price>8.99</price>
            </book>
        </books>
    </data>
</response>
 */
