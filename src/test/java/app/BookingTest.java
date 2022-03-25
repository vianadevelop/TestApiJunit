package app;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import step.booking.BookerSteps;
import utils.Specifications;
import utils.constants.Endpoint;

import java.util.List;

/**
 * @author Edward
 * @since 03/24/2022
 */
@RunWith(SerenityRunner.class)
public class BookingTest extends TestBase {

    @Steps
    BookerSteps steps;

    @Test
    public void getAllBookings() {
        RequestSpecification reqSpec = new Specifications().buildSpecification();

        List<Integer> bookings = steps.getObjects(Endpoint.BOOKING.getValue(), reqSpec)
                .statusCode(200)
                .extract()
                .path("bookingid");

        Assert.assertTrue(bookings.size() > 0);
    }
}
