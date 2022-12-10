package test;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

        RestApiUtils restApiUtils = new RestApiUtils();


    @Test
    public void verifyUserWithID() {
        //JSONPATH ile dogruilama yapalim
        JsonPath json = restApiUtils.checkUserWithIDGet(114351).jsonPath();
        Assert.assertEquals("Della", json.get("firstName"));
        Assert.assertEquals("Heaney", json.get("lastName"));
        Assert.assertEquals("ricardo.larkin@yahoo.com", json.get("email"));
    }

    @Test
    public void createUserTestPost() {
        restApiUtils.postUserApiCall("Erva","3500","37").prettyPrint() ;
    }

}