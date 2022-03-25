package step.booking;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import step.GenericSteps;
import utils.Specifications;
import utils.constants.Endpoint;
import utils.constants.PathParams;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Edward
 * @since 03/24/2022
 */
public class BookerSteps extends GenericSteps {

    /**
     *
     * @param path
     * @param resSpec
     * @return ValidatableResponse
     */
    @Step
    public ValidatableResponse getObjects(String path, RequestSpecification resSpec) {
        return get(path, resSpec);
    }

    /**
     *
     * @param id
     * @return ValidatableResponse
     */
    @Step
    public ValidatableResponse getById(int id){
        Map<String, ?> pathParams = new HashMap<String, Integer>(){{
            put(PathParams.BOOKING_ID.getValue(), id);
        }};

        RequestSpecification reqSpec = new Specifications(){{
            setContentType(ContentType.JSON);
            setPathParams(pathParams);
        }}.buildSpecification();
        return get(Endpoint.BOOKING.getValue(), reqSpec);
    }
}
