package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Edward
 * @since 03/28/2022
 */
@Data
public class BookingDate {
    @JsonProperty("checkin")
    private String checkIn;
    @JsonProperty("checkout")
    private String checkOut;
}
