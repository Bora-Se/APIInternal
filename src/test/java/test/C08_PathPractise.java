package test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class C08_PathPractise {
    /*
   {
   "firstName": "John",
   "lastName": "doe",
   "age": 26,
   "address":       {
                    "streetAddress": "naist street",
                    "city": "Nara",
                    "postalCode": "630-0192"
                    },
   "phoneNumbers": [
                     {
                         "type": "iPhone",
                         "number": "0123-4567-8888"
                     },
                     {
                         "type": "home",
                         "number": "0123-4567-8910"
                     }
                    ]
    }
    */
    @Test
    public void jsonPath01() throws JSONException {
        JSONObject personelInfo = new JSONObject();
        JSONObject addressInfo = new JSONObject();
        JSONObject mobileInfo = new JSONObject();
        JSONObject homeTelInfo = new JSONObject();
        JSONArray phoneInfo = new JSONArray();

        personelInfo.put("firstName","John");
        personelInfo.put("lastName","doe");
        personelInfo.put("age",26);
        personelInfo.put("address",addressInfo);
        personelInfo.put("phoneNumbers",phoneInfo);

        addressInfo.put("streetAddress","naist street");
        addressInfo.put("city","Nara");
        addressInfo.put("postalCode","630-0192");

        mobileInfo.put("type","iPhone");
        mobileInfo.put("number","0123-4567-8888");

        homeTelInfo.put("type","home");
        homeTelInfo.put("number","0123-4567-8910");

        phoneInfo.put(mobileInfo);
        phoneInfo.put(homeTelInfo);


        System.out.println(personelInfo);
        System.out.println("Name : " + personelInfo.get("firstName"));
        System.out.println("LastName : " + personelInfo.get("lastName"));
        System.out.println("Age : " + personelInfo.get("age"));
        System.out.println("Street : " + personelInfo.getJSONObject("address").get("streetAddress"));
        System.out.println("City : " + personelInfo.getJSONObject("address").get("city"));
        System.out.println("Postal Code : " + personelInfo.getJSONObject("address").get("postalCode"));
        System.out.println("Mobile : " + personelInfo.getJSONArray("phoneNumbers").
                getJSONObject(0).get("type"));
        System.out.println("Home Telephone : " + personelInfo.getJSONArray("phoneNumbers").
                getJSONObject(1).get("number"));

    }
}