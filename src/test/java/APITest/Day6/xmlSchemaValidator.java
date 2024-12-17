package APITest.Day6;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class xmlSchemaValidator {

    //We will be validating the data type of each field with schema validation
    //We will take response of API and use one website to convert response to xsd schema
    //https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/
    //xml response(.xml)-->xml schema(.xsd)

    @Test
    void xmlSchemaValidation(){

        given()
                .when()
                .get("url")
                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchema.xsd"));
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
