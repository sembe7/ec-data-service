package mn.astvision.starter.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.astvision.starter.model.ec.City;
import mn.astvision.starter.model.ec.Location;
import mn.astvision.starter.repository.ec.LocationRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Sembe
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class locationCron {

    private final LocationRepository locationRepository;
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    // run every 10 minutes
    @Scheduled(initialDelay = 1000, fixedRate = 10 * 60 * 1000)
    private void getLocation() {
        System.out.println("started cron");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();

            String sql = "SELECT * FROM location";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            List<Location> locationList = new ArrayList<>();
            for (Map<String, Object> map : list) {
                Location location = new Location();
                location.setId((Integer) map.get("id"));
                location.setDistrict((Integer) map.get("district"));
                location.setQuarter((String) map.get("quarter"));
                location.setStreet((String) map.get("street"));
                location.setAddress((String) map.get("address"));
                location.setName((String) map.get("name"));
                location.setCreated_user_id((Integer) map.get("created_user_id"));
                Object obj = map.get("created_date");
                String dateStr = obj.toString();
                String regexedStrDateTime = dateStr.replace ( " " , "T" );
                LocalDateTime dateTime = LocalDateTime.parse(regexedStrDateTime);
                location.setCreated_date(dateTime);
                locationRepository.save(location);
                locationList.add(location);
            }
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {}
            }
        }

    }

}
