package mn.astvision.starter.repository.ec;

import mn.astvision.starter.model.ec.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sembe
 */
@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
}
