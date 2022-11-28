package mn.astvision.starter.model.ec;

import lombok.Data;
import mn.astvision.starter.model.BaseEntity;
import org.springframework.data.annotation.Id;

/**
 * @author Sembe
 */
@Data
public class ProductCategory {
    @Id
    private Integer id;
    private String name;
    private Integer parent_id;
}
