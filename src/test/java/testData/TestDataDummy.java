package testData;
import jdk.security.jarsigner.JarSigner;
import org.json.JSONObject;
public class TestDataDummy {
    public int statusCode = 200;
    public String contentType = "application/json";

    public JSONObject innerDataJsonBodyOlustur (){
        JSONObject innerDataBodyJSON = new JSONObject();
        innerDataBodyJSON.put("id",3);
        innerDataBodyJSON.put("employee_name","Ashton Cox");
        innerDataBodyJSON.put("employee_salary",86000);
        innerDataBodyJSON.put("employee_age",66);
        innerDataBodyJSON.put("profile_image","");
        return innerDataBodyJSON;
    }

    public JSONObject expectedDataBodyOlustur (){

        JSONObject expDataJSON = new JSONObject();

        expDataJSON.put("status","success");
        expDataJSON.put("data",innerDataJsonBodyOlustur());
        expDataJSON.put("message","Successfully! Record has been fetched.");
        return expDataJSON;
    }

}
