package mn.astvision.starter.model.ec;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Sembe
 */
@Data
public class District {
    @Id
    private Integer id;
    private Integer city_id;
    private String name;
}
