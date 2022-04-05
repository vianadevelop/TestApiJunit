package stepsDefs;

import entity.Booking;
import entity.BookingDate;
import entity.BookingParent;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import step.booking.BookerSteps;
import utils.constants.Endpoint;

import java.util.Random;

/**
 * @author Edward
 * @since 04/04/2022
 */
public class BookingStepdefs {
    @Steps
    BookerSteps steps;

    BookingDate bookingDate;
    Booking booking;
    ValidatableResponse vr;
    BookingParent bookingParent;

    @Given("{string} {string} is a tourist in Guatemala")
    public void isATouristInGuatemala(String firstname, String lastname) {
        booking = new Booking();
        booking.setFirstname(firstname);
        booking.setLastname(lastname);
    }

    @And("needs lodging on the date {string} to {string}")
    public void needsLodgingOnTheDateTo(String checkIn, String checkOut) {
        bookingDate = new BookingDate();
        bookingDate.setCheckIn(checkIn);
        bookingDate.setCheckOut(checkOut);
        booking.setBookingDates(bookingDate);
    }

    @But("the room must include {string}")
    public void theRoomMustInclude(String additionalNeeds) {
        booking.setAdditionalNeeds(additionalNeeds);
    }

    @When("owner create the booking")
    public void ownerCreateTheBooking() {
        Random rand = new Random();
        booking.setTotalPrice(rand.nextInt(150));
        booking.setDepositPaid(rand.nextBoolean());
        vr = steps.createAnObject(booking, Endpoint.BOOKING.getValue());

    }

    @Then("the system confirm booking with status code {int}")
    public void theSystemConfirmBookingWithStatusCode(int statusCode) {
        bookingParent = vr.assertThat()
                .statusCode(statusCode)
                .and()
                .extract()
                .as(BookingParent.class);
    }

    @And("Total Price less than $ {int}")
    public void totalPriceLessThan$TotalPrice(int totalPrice) {
        Assert.assertTrue(bookingParent.getBooking().getTotalPrice() < totalPrice);
    }
}
