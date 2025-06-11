package APITest.Misc;

import org.testng.annotations.Test;


import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class fileUploadAndDownload {


    @Test
    void singleFileUpload(){
        File file=new File("Location of file");

        given()
                .multiPart("file",file)
                .contentType("multipart/form-data")
        .when()
                .post("url")
                .then()
                .statusCode(200)
                .body("fileName",equalTo("Test1.txt"))
                .log().all();
        //Refer to session 5
    }

    @Test
    void multipleFileUpload(){
        File file1=new File("Location of file 1");
        File file2=new File("Location of file 2");

        given()
                .multiPart("files",file1)
                .multiPart("files",file2)
                .contentType("multipart/form-data")
                .when()
                .post("url")
                .then()
                .statusCode(200)
                .body("[0].fileName",equalTo("Test1.txt"))
                .body("[1].fileName",equalTo("Test2.txt"))
                .log().all();
        //Refer to session 5
    }

    @Test
    void multipleFilesUpload(){
        //if more than 2 files has to be uploaded
        //This approach may not work for every kind of API's
        File file1=new File("Location of file 1");
        File file2=new File("Location of file 2");

        File filearr[]={file1,file2};//add all the files object here as part of list

        given()
                .multiPart("files",filearr)
                .contentType("multipart/form-data")
                .when()
                .post("url")
                .then()
                .statusCode(200)
                .body("[0].fileName",equalTo("Test1.txt"))
                .body("[1].fileName",equalTo("Test2.txt"))
                //we can add multiple file name here as well
                .log().all();
        //Refer to session 5
    }

    @Test
    void downloadFile(){
        given()
                .when()
                .get("give the url you will get as part of response of file upload api")//refer session 5
                .then()
                .statusCode(200)
                .log().all();
    }
}

/*
Sample of the response after file upload

{
"fileName":"Text1.txt",
"fileDownloadUri":"http://localhost:8080/downloadFile/Text1",
"fileType":"text/plain",
"size":70
}

 */