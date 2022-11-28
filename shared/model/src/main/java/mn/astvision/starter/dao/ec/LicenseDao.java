package mn.astvision.starter.dao.ec;

import lombok.RequiredArgsConstructor;
import mn.astvision.starter.model.ec.License;
import mn.astvision.starter.repository.ec.LicenseRepository;
import mn.astvision.starter.util.MongoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Sembe
 */
@RequiredArgsConstructor
@Repository
public class LicenseDao {

    private final MongoTemplate mongoTemplate;
    private final MongoUtil mongoUtil;

    public Long count(String number, Integer year, Integer part, Boolean tax_paid) {
        return mongoTemplate.count(buildPredicate(number, year, part, tax_paid, null), License.class);
    }

    public Iterable<License> list(String number, Integer year, Integer part, Boolean tax_paid, Pageable pageable) {
        return mongoTemplate.find(buildPredicate(number, year, part, tax_paid, pageable), License.class);

    }

    private Query buildPredicate(String number, Integer year, Integer part, Boolean tax_paid, Pageable pageable) {
        Query query = new Query();

        if (number != null)
            mongoUtil.queryIs(query, number, "number");
        if (year != null)
            mongoUtil.queryIs(query, year, "year");
        if (part != null)
            mongoUtil.queryIs(query, part, "part");
        if (tax_paid != null)
            mongoUtil.queryIs(query, tax_paid, "tax_paid");
        if (pageable != null)
            mongoUtil.queryPageable(query, pageable);

        return query;
    }
}
