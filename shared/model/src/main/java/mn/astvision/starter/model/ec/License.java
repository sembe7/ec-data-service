package mn.astvision.starter.model.ec;

import lombok.Data;
import mn.astvision.starter.model.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Sembe
 */

@Data
public class License {
    private Integer id;
    private LocalDateTime created_date;
    private String kiosk_transaction_id;
    private String number;
    private Integer year;
    private Integer part;
    private String base_type;
    private String inspection_class;
    private String country;
    private String mark;
    private String model;
    private String brand;
    private Integer total_weight;
    private Integer axle_count;
    private LocalDateTime inspection_expiry_date;
    private Boolean inspection_passed;
    private Boolean tax_paid;
    private LocalDateTime insurance_expiry_date;
    private Integer penalty_count;
    private String license_class;
    private String caravan_number;
    private Integer caravan_weight;
    private Integer caravan_axle_count;
    private Integer type;
    private BigDecimal fee;
    private Boolean re_print;
    private Integer dc_id;
}
