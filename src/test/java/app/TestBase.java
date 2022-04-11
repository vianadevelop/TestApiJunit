package app;

import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import utils.PropertySource;
import utils.constants.KeyProperties;

/**
 * @author Edward
 * @since 03/24/2022
 */
public class TestBase {

    @BeforeClass
    public static void runOnceBeforeClass() {
        PropertySource prop = new PropertySource();
        RestAssured.baseURI = prop.getProperty(KeyProperties.BASE_URI.getValue());
        RestAssured.port = Integer.parseInt(prop.getProperty(KeyProperties.PORT.getValue()));
        RestAssured.useRelaxedHTTPSValidation();
    }

    @AfterClass
    public static void runOnceAfterClass() {
        RestAssured.reset();
    }
}
