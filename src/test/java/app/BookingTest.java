package app;

import entity.Booking;
import entity.BookingDate;
import entity.BookingParent;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import step.booking.BookerSteps;
import utils.Specifications;
import utils.constants.Endpoint;
import utils.constants.StatusCode;

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

    @Test
    public void getExistingBookingId() {
        // create a booking with dummy data
        BookingDate bookingDate = new BookingDate() {{
            setCheckIn("2022-04-22");
            setCheckOut("2022-04-28");
        }};
        Booking booking = new Booking() {{
            setFirstname("session");
            setLastname("four");
            setTotalPrice(123);
            setDepositPaid(true);
            setBookingDates(bookingDate);
            setAdditionalNeeds("breakfast");
        }};

        BookingParent bookingParent = steps.createAnObject(booking, Endpoint.BOOKING.getValue())
                .assertThat()
                .statusCode(StatusCode.OK.getValue())
                .and()
                .extract()
                .as(BookingParent.class);

       Assert.assertEquals(bookingParent.getBooking().getFirstname(),booking.getFirstname());
    }
}
