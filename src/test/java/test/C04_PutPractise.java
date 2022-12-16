package test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class C04_PutPractise {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Cemile",
                "body":"Barak",
                "userId":3,
                "id":1
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
                 */
    @Test
    public void put01(){
        // 1- Request için URL ve Body hazırla
        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "Cemile");
        reqBody.put("body", "Barak");
        reqBody.put("userId", 3);
        reqBody.put("id", 1);
        // 2- Expected Datayi hazırla
        // 3- Reponse'u kaydet
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put(url);
        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");
    }
}