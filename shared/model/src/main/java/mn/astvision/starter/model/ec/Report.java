package mn.astvision.starter.model.ec;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import mn.astvision.starter.model.ec.enums.ReportStatus;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Sembe
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report {
    @Id
    private int license_id;

    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private LocalDateTime submitted_date;
    private ReportStatus report_status;
    private LocalDateTime closed_date;
    private LocalDateTime replied_date;
    private short entity_type;

    private String registry_number;

    private String company_name;
    private String director_mame;
    private String lastname;
    private String firstname;

    private String phone;

    private String email;

    private Integer district_zip;
    private String quarter;
    private String street;
    private String address;

    private String insurance_company;
    private LocalDate insurance_expiry_date;
    private String driver_lastname;
    private String driver_firstname;
    private String driver_license_class;
    private String driver_license_number;
    private String driver_pro_license_class;
    private String driver_pro_license_number;
    private Short in_business_since;
    private Boolean has_parking;
    private Boolean has_engineer;
}
