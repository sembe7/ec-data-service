package mn.astvision.starter.model.ec;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sembe
 */
@Data
public class City {
    private Integer id;
    private String name;
    private Set<District> districts = new HashSet<>(0);
}
