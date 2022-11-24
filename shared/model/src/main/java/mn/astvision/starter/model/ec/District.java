package mn.astvision.starter.model.ec;

import lombok.Data;

/**
 * @author Sembe
 */
@Data
public class District {
    private Integer id;
    private City city;
    private String name;
}
