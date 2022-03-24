package app;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class BookingSteps {

    public ValidatableResponse get(String url){
       return RestAssured
               .given()
               .when()
                    .get(url)
               .then();
    }

}
