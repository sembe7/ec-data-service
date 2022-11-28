package mn.astvision.starter.repository.ec;

import mn.astvision.starter.model.ec.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sembe
 */
@Repository
public interface CityRepository extends MongoRepository<City, String> {
}
