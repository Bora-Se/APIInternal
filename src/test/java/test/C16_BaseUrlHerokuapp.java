package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C16_BaseUrlHerokuapp extends HerokuAppBaseUrl {


    //Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

    @Test
    public void get01(){

         /*1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response'un status code'unun 200 oldugunu
        ve Response'ta 48 booking oldugunu test edin */

        // 1 - Url ve body hazirla, get ve delete metodunda body ihtiyacimiz yok
        specHerokuApp.pathParam("pp1","booking");

        // 2 - Expected Data hazirla
        // 3 - Response'u kaydet
        Response response = given().
                spec(specHerokuApp).
                when().
                get("/{pp1}");
        response.prettyPrint();
        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid", hasItem(24389));


    }


    @Test
    public void post01(){

   /* 2- https://restful-booker.herokuapp.com/booking endpointine asagidaki
     body'ye sahip bir POST request gonderdigimizde donen response'un status
     code'unun 200 oldugunu ve "firstname" degerinin "Ali" oldugunu test edin

  {
  "firstname" : "Ali",
  "lastname" : "Bak",
  "totalprice" : 500,
  "depositpaid" : false,
  "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
                },
  "additionalneeds" : "wi-fi"
   }     */

        // 1 - Url ve body hazirla, get ve delete metodunda body ihtiyacimiz yok
        specHerokuApp.pathParam("pp1","booking");

        JSONObject innerBody = new JSONObject();
        JSONObject regBody = new JSONObject();
        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");
        regBody.put("firstname", "Ali");
        regBody.put("lastname", "Bak");
        regBody.put("totalprice", 500);
        regBody.put("depositpaid", false);
        regBody.put("bookingdates", innerBody);
        regBody.put("additionalneeds", "wi-fi");

        // 2 - Expected Data hazirla

        // 3 - Response ' u kaydet
        Response response = given().
                            spec(specHerokuApp).
                            contentType(ContentType.JSON).
                        when().
                            body(regBody.toString()).
                        post("/{pp1}");
        response.prettyPrint();

        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("booking.firstname",equalTo("Ali"));

    }

}
