package mn.astvision.starter.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.astvision.starter.model.ec.License;
import mn.astvision.starter.repository.ec.LicenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Sembe
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class LicenseCron {

    private final JdbcTemplate jdbcTemplate;
    private final LicenseRepository licenseRepository;

    // run every 1 minutes
//    @Scheduled(initialDelay = 1000, fixedRate = 1 * 60 * 1000)
    private void getLicense() {
        try {
            String sql = "SELECT * FROM license";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

            for (Map<String, Object> map : list) {
                License license = new License();
                license.setId((Integer) map.get("id"));

                Object createdDateObj = map.get("created_date");
                String createdDateStr = createdDateObj.toString();
                String regexedCreatedDateTime = createdDateStr.replace ( " " , "T" );
                license.setCreated_date(LocalDateTime.parse(regexedCreatedDateTime));

                license.setKiosk_transaction_id((String) map.get("kiosk_transaction_id"));
                license.setNumber((String) map.get("number"));
                license.setYear((Integer) map.get("year"));
                license.setPart((Integer) map.get("part"));
                license.setBase_type((String) map.get("baseType"));
                license.setInspection_class((String) map.get("inspection_class"));
                license.setCountry((String) map.get("country"));
                license.setMark((String) map.get("mark"));
                license.setModel((String) map.get("model"));
                license.setBrand((String) map.get("brand"));
                license.setTotal_weight((Integer) map.get("total_weight"));
                license.setAxle_count((Integer) map.get("axle_count"));

                Object inspection_expiry_date = map.get("created_date");
                String inspection_expiry_date_str = inspection_expiry_date.toString();
                String regexed_inspection_expiry_date_str = inspection_expiry_date_str.replace ( " " , "T" );
                license.setInspection_expiry_date(LocalDateTime.parse(regexed_inspection_expiry_date_str));

                license.setInspection_passed((Boolean) map.get("inspection_passed"));
                license.setTax_paid((Boolean) map.get("tax_paid"));

                Object insurance_expiry_date = map.get("created_date");
                String insurance_expiry_date_str = insurance_expiry_date.toString();
                String regexed_insurance_expiry_date_str = insurance_expiry_date_str.replace ( " " , "T" );
                license.setInsurance_expiry_date(LocalDateTime.parse(regexed_insurance_expiry_date_str));

                license.setPenalty_count((Integer) map.get("penalty_count"));
                license.setLicense_class((String) map.get("license_class"));
                license.setCaravan_number((String) map.get("caravan_number"));
                license.setCaravan_weight((Integer) map.get("caravan_weight"));
                license.setCaravan_axle_count((Integer) map.get("caravan_axle_count"));
                license.setType((Integer) map.get("type"));
                license.setFee((BigDecimal) map.get("fee"));
                license.setRe_print((Boolean) map.get("re_print"));
                license.setDc_id((Integer) map.get("dc_id"));

                licenseRepository.save(license);
            }

        } catch (Exception e) {
            log.info("error license: " + e.getMessage());
        }
    }

}
