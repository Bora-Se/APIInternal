package test;
import org.json.JSONObject;
import org.junit.Test;
public class C03_ObjePractise {
    @Test
    public void jsonobje01() {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
    "title":"Levent",
    "body":"Deneme",
    "userId":111
    }
     */
        JSONObject ilkJSonObje = new JSONObject();
        ilkJSonObje.put("title", "Levent");
        ilkJSonObje.put("body", "Deneme");
        ilkJSonObje.put("userId", 111);
        System.out.println(ilkJSonObje);
    }
    @Test
    public void jsonobje02(){
    /* Asagidaki JSON Objesini olusturup konsolda yazdirin.
                {
                 "firstname":"Levent",
                 "lastname":"Ozkul",
                 "additionalneeds":"Breakfast",
                 "bookingdates1":  {
                                   "checkin":"2023-01-01",
                                   "checkout":"2023-01-08"
                                   },
                  "bookingdates2":  {
                                   "checkin":"2024-01-01",
                                   "checkout":"2024-01-08"
                                   },
                  "totalprice":5000,
                  "depositpaid":true
                  }
    */
        JSONObject innerJson1 = new JSONObject();
        innerJson1.put("checkin", "2023-01-01");
        innerJson1.put("checkout", "2023-01-08");
        JSONObject innerJson2 = new JSONObject();
        innerJson2.put("checkin", "2024-01-01");
        innerJson2.put("checkout", "2024-01-08");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("firstname", "Levent");
        jsonObject2.put("lastname","Ozkul");
        jsonObject2.put("additionalneeds","Breakfast");
        jsonObject2.put("bookingdates1", innerJson1);
        jsonObject2.put("bookingdates2", innerJson2);
        jsonObject2.put("totalprice", 5000);
        jsonObject2.put("depositpaid", true);
        System.out.println(jsonObject2);
    }
}