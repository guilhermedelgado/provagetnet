package ProvaGetnet;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements Constantes {
    @BeforeClass
    public static void setup()
    {
        baseURI = APP_BASE_URL;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        responseSpecification = resBuilder.build();

        enableLoggingOfRequestAndResponseIfValidationFails();




    }



}