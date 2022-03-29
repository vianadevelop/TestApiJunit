package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Edward
 * @since 03/28/2022
 */
@Data
public class BookingParent {
    @JsonProperty("bookingid")
    private int bookingId;
    private Booking booking;
}
