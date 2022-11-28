package mn.astvision.starter.model.ec;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author Sembe
 */
@Data
public class Location {
    @Id
    private Integer id;
    private Integer district;
    private String quarter;
    private String street;
    private String address;
    private String name;
    private Integer created_user_id;
    private LocalDateTime created_date;
}
