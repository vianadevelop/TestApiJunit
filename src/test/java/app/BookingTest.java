package app;

import org.junit.Test;

import static org.hamcrest.Matchers.hasItems;

public class BookingTest extends TestBase{

    BookingSteps steps;
    public BookingTest(){
        steps = new BookingSteps();
    }
    @Test
    public void getAllBookings() {
        steps
                .get("/booking")
                .statusCode(200)
                    .and()
                .body("bookingid.findAll { it < 5}",hasItems(1,2,3,4));
    }

}
