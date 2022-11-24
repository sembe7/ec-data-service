package mn.astvision.starter.model.ec.enums;

/**
 *
 * @author MethoD
 */
public enum ReportStatus {

    DRAFT(0, "Ноорог", "label-default"),
    PENDING(1, "Хүлээгдэж байгаа", "label-warning"),
    REJECTED(2, "Буцаагдсан", "label-danger"),
    APPROVED(3, "Хүлээн авсан", "label-success");

    int value;
    String description;
    String cssClass;

    ReportStatus(int value, String description, String cssClass) {
        this.value = value;
        this.description = description;
        this.cssClass = cssClass;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getCssClass() {
        return cssClass;
    }
}
