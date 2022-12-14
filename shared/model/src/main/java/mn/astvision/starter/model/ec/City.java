package mn.astvision.starter.model.ec;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sembe
 */
@Data
public class City {
    @Id
    private Integer id;
    private String name;
    private Set<District> districts = new HashSet<>(0);
}
