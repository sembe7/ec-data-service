package mn.astvision.starter.model.ec;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import mn.astvision.starter.model.ec.enums.ReportStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sembe
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report {

    private int licenseId;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime submittedDate;
    private ReportStatus reportStatus;
    private LocalDateTime closedDate;
    private LocalDateTime repliedDate;
    private short entityType;

    private String registryNumber;

    private String companyName;
    private String directorName;
    private String lastname;
    private String firstname;

    private String phone;

    private String email;

    private District district;
    private String quarter;
    private String street;
    private String address;

    private String insuranceCompany;
    private LocalDate insuranceExpiryDate;
    private String driverLastname;
    private String driverFirstname;
    private String driverLicenseClass;
    private String driverLicenseNumber;
    private String driverProLicenseClass;
    private String driverProLicenseNumber;
    private Short inBusinessSince;
    private Boolean hasParking;
    private Boolean hasEngineer;
    private Set<ReportData> reportDatas = new HashSet<>(0);

    private String action;
    private String actionParam;
}
