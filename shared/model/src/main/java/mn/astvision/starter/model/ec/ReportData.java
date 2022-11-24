package mn.astvision.starter.model.ec;
// Generated May 28, 2018 4:01:38 PM by Hibernate Tools 4.3.1

import lombok.Data;

@Data
public class ReportData implements java.io.Serializable {

    private Integer id;
    private String locationByDestination;
    private String locationByOrigin;
    private Report report;
    private String period;
    private int periodValue;
    private float totalFreightAmount;
    private float freightTraffic;


}
