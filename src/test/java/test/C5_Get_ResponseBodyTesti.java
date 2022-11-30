package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C5_Get_ResponseBodyTesti {

    /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in
             status code'unun 200,
             ve content type'inin Aplication.JSON,
             ve response body'sinde bulunan userId'nin 5,
             ve response body'sinde bulunan title'in "optio dolor molestias sit"
             oldugunu test edin.
         */

    @Test
    public void get01(){

        // 1- Request icin Url ve Body hazirla Get ve Delete de, requestt icin body ihtiyac yok, Put, patch ve post islemleri icin body gondermek zorundayiz
    String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Soruda verilmisse, Expected Datayi hazirla -- henuz karsilastirma yok

        //3- Response'u kaydet
        Response response = given().when().get(url);  // Response de given().when() olmak zorunda
        //response.prettyPrint();

        // 4- Assertion olusturalim

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", Matchers.equalTo(5)).
                body("title", Matchers.equalTo("optio dolor molestias sit"));

        /*{
    "userId": 5,
    "id": 44,
    "title": "optio dolor molestias sit",
    "body": "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam
    qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
}         */



    }

}
