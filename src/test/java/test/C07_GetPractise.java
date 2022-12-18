package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_GetPractise {

    /*
                https://restful-booker.herokuapp.com/booking/1 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Sally",
                    ve "lastname“in, "Jackson",
                    ve "totalprice“in,927,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

    @Test
    public void get01(){
        // 1- Request için URL ve Body hazırla (bu soruda body testi yok)
        String url = "https://restful-booker.herokuapp.com/booking/100";


        // 2- Expected Datayi hazırla


        // 3- Reponse'u kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4 A - Assertion asıl yöntem.
/*
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Sally")).
                body("lastname", Matchers.equalTo("Jackson")).
                body("totalprice", Matchers.equalTo(927)).
                body("depositpaid", Matchers.equalTo(true)).
                body("additionalneeds", Matchers.equalTo("Breakfast"));

*/
        // 4 B - Assertion kisaltma

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "additionalneeds", equalTo("Breakfast"));



    }

}
