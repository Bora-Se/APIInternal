package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C6_Post_ResponseBodyTesti {


    @Test
    public void post01(){
        /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        { "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */



        // 1- Request icin Url ve Body hazirla Get ve Delete de, requestt icin body ihtiyac yok,
        // Put, patch ve post islemleri icin body gondermek zorundayiz
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody = new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        // 2- Soruda verilmisse, Expected Datayi hazirla -- henuz karsilastirma yok
        //3- Response'u kaydet

        Response response = given().contentType(ContentType.JSON).
                            when().body(reqBody.toString()).
                                post(url);  // Response de; given().when() ve Http metodu olmak zorunda
        //response.prettyPrint();

        // 4- Assertion olusturalim

        response.then().assertThat().
                statusCode(201).
                contentType(ContentType.JSON).
                body("title", Matchers.equalTo("API")).
                body("userId",Matchers.lessThan(100)).
                body("body",Matchers.containsString("API"));



    }

}
