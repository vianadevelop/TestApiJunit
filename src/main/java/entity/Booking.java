package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Edward
 * @since 03/28/2022
 */
@Data
public class Booking {
    private String firstname;
    private String lastname;
    @JsonProperty("totalprice")
    private int totalPrice;
    @JsonProperty("depositpaid")
    private boolean depositPaid;
    @JsonProperty("bookingdates")
    private BookingDate bookingDates;
    @JsonProperty("additionalneeds")
    private String additionalNeeds;
}
