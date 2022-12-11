package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data    //Getter and Setter lari otomatik getiriyor
@NoArgsConstructor   //
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)

public class PojoHerokuappBookingDates {

    /*
     {
      "checkin":"2021-06-01",
      "checkout":"2021-06-10"
                           }
      */
    private String checkin;
    private String checkout;
}
