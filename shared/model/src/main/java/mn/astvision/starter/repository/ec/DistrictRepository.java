package mn.astvision.starter.repository.ec;

import mn.astvision.starter.model.ec.District;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sembe
 */
@Repository
public interface DistrictRepository extends MongoRepository<District, String> {
}
