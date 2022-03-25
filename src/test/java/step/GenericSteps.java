package step;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

/**
 * @author Edward
 * @since 03/24/2022
 */
public class GenericSteps {
    /**
     * Generic method to make a Get request
     * @param path
     * @param reqSpec
     * @return ValidatableResponse
     */
    protected ValidatableResponse get(String path, RequestSpecification reqSpec){
        return SerenityRest
                .rest()
                .given()
                    .spec(reqSpec)
                .when()
                    .get(path)
                .then();
    }
}
