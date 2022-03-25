package app;

import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Edward
 * @since 03/24/2022
 */
public class TestBase {

    @BeforeClass
    public static void runOnceBeforeClass() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.port = 443;
        RestAssured.useRelaxedHTTPSValidation();
    }

    @AfterClass
    public static void runOnceAfterClass() {
        RestAssured.reset();
    }
}
