package Jekins;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class JekinsTests {

    @Test
    public void apiTest(){
        RequestSpecification spec =new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

        //set the base url and path params
        spec.pathParams("first","booking","second",3);

        //send the request get the response
        Response response =given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

        Map<String,Object> actualDAta= response.as(HashMap.class);

        //Map<String ,Object> map=new HashMap<>();


        System.out.println("actualDAta = " + actualDAta);
        Map<String ,Object> bookingdates= (Map)actualDAta.get("bookingdates");

        assertEquals("Jim",actualDAta.get("firstname"));
        assertEquals("Jackson",actualDAta.get("lastname"));
        assertEquals("982",actualDAta.get("totalprice"));
        //



    }
}
