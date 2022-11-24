package mn.astvision.starter.model.ec.enums;

/**
 * @author Sembe
 */
public enum ReportRequest {
    CITIZEN("citizen", "Report", "Хувь хүн", "r.entity_type as citizen"),
    ENTITY("entity", "Report", "ААН", "r.entity_type as entity"),
    REGISTRY_NUMBER("registry_number","Report", "Регистрийн дугаар", "r.registry_number"),
    COMPANY_NAME("company_name","Report", "Байгууллагын нэр", "r.company_name"),
    DIRECTOR_NAME("director_name", "Report","Захирлын нэр", "r.director_name"),
    LAST_NAME("lastname", "Report", "Овог", "r.lastname"),
    FIRST_NAME("firstname","Report", "Нэр", "r.firstname"),
    PHONE("phone", "Report","Утас", "r.phone"),
    EMAIL("email", "Report","И-Мэйл", "r.email"),
    DISTRICT_ZIP("district_zip", "Report", "Хаяг(Хот/Аймаг)", "r.district_zip"), //city table
//    DISTRICT("district", "Report", "Хаяг(Сум/Дүүрэг)", "r.kkkkkkk"),//district table
    QUARTER("quarter","Report", "Хороо", "r.quarter"),
    STREET("street", "Report","Гудамж", "r.street"),
    ADDRESS("address", "Report","Дэлгэрэнгүй хаяг", "r.address"),
    DRIVER_LASTNAME("driver_lastname", "Report", "Жолоочийн овог", "r.driver_lastname"),
    DRIVER_FIRSTNAME("driver_firstname","Report", "Жолоочийн нэр", "r.driver_firstname"),
    DRIVER_LICENSE_CLASS("driver_license_class", "Report","Жолоочийн үнэмлэх ангилал", "r.driver_license_class"),
    DRIVER_LICENSE_NUMBER("driver_license_number", "Report", "Жолоочийн үнэмлэх дугаар", "r.driver_license_number"),
    DRIVER_LICENSE_PRO_CLASS("driver_pro_license_class", "Report","Жолоочийн мэргэшсэн үнэмлэх ангилал", "r.driver_pro_license_class"),
    DRIVER_LICENSE_PRO_NUMBER("driver_pro_license_number", "Report", "Жолоочийн мэргэшсэн үнэмлэх дугаар", "r.driver_pro_license_number"),
    INSURANCE_COMPANY("insurance_company","Report", "Даатгалтай компани", "r.insurance_company"),
    INSURANCE_EXPIRY_DATE("insurance_expiry_date", "Report","Даатгал дуусах огноо", "r.insurance_expiry_date"),
    IN_BUSINESS_SINCE("in_business_since","Report", "Үйлчилгээ эхэлсэн он", "r.in_business_since"),
    HAS_PARKING("has_parking", "Report","Граштай эсэх", "r.has_parking"),
    HAS_ENGINEER("has_engineer", "Report", "Инженер техникийн ажилтан", "r.has_engineer"),
    DESTINATION("destination","ReportData", "Ачаа шингэх цэг", "rd.destination"),
    ORIGIN("origin", "ReportData","Ачаа эхлэх цэг", "rd.origin"),
    PERIOD("period", "ReportData", "Тээвэрлэлт давтамж", "rd.period"),
    PERIOD_VALUE("period_value","ReportData", "Тээвэрлэлт давтамж (удаа)", "rd.period_value"),
    FREIGHT_TRAFFIC("freight_traffic","ReportData", "Туулсан зай", "rd.freight_traffic"),
    CATEGORY_ID("category_id","ReportFreightData", "Ачааны төрөл", "rfd.category_id"),
    TOTAL_FREIGHT_AMOUNT("total_freight_amount", "ReportData","Нийт ачааны хэмжээ", "rd.total_freight_amount"),
    NUMBER("number", "License", "ТХ-ийн дугаар", "l.number"),
    SUBMITTED_DATE("submitted_date", "Report","Тайлан баталгаажсан огноо", "r.submitted_date");


//    ENTITY_TYPE("entityType", "Report", "ААН эсэх", "r.kkkkkkk"),
//    CREATED_DATE("created_date","Report", "Тайлан бүртэгсэн өдөр", "r.kkkkkkk"),
//
//    REPORT_STATUS("report_status", "Report", "Тайлангын төлөв", "r.kkkkkkk"),

//    CREATED_DATE_LICENSE("created_date","License", "Лиценз бүртэгсэн өдөр", "r.kkkkkkk"),
//    KIOSK_TRANSACTION_ID("kiosk_transaction_id", "License","KIOSK id", "r.kkkkkkk"),
//    YEAR_LICENSE("year","License", "Жил", "r.kkkkkkk"),
//    PART_LICENSE("part", "License","Ээлж", "r.kkkkkkk"),
//    BASE_TYPE("base_type", "License", "Зориулалт", "r.kkkkkkk"),
//    INSPECTION_CLASS("inspection_class","License", "Компаний нэр", "r.kkkkkkk"),
//    COUNTRY("country", "License","Улс", "r.kkkkkkk"),
//    MARK("mark", "License", "Марк", "r.kkkkkkk"),
//    MODEL("model","License", "Модел", "r.kkkkkkk"),
//    BRAND("brand", "License","brand", "r.kkkkkkk"),
//    TOTAL_WEIGHT("total_weight", "License", "Жин", "r.kkkkkkk"),
//    AXLE_COUNT("axle_count","License", "Тэнхлэг тоо", "r.kkkkkkk"),
//    INSPECTION_EXPIRY_DATE("inspection_expiry_date", "License","Үзлэгийн хамрагдсан огноо", "r.kkkkkkk"),
//    INSPECTION_PASSED("inspection_passed", "License", "Үзлэгт тэнцсэн эсэх", "r.kkkkkkk"),
//    TAX_PAID("tax_paid","License", "Татвар төлсөн эсэх", "r.kkkkkkk"),
//    INSURANCE_EXPIRY_DATE_LICENSE("insurance_expiry_date", "License","Даатгал баталгаажсан өдөр", "r.kkkkkkk"),
//    PENALTY_COUNT("penalty_count", "License", "Торгуулийн тоо", "r.kkkkkkk"),
//    LICENSE_CLASS("license_class","License", "Ангилал", "r.kkkkkkk"),
//    CARAVAN_NUMBER("caravan_number", "License","Чиргүүлийн дугаар", "r.kkkkkkk"),
//    CARAVAN_WEIGHT("caravan_weight", "License", "Чиргүүлийн жин", "r.kkkkkkk"),
//    CARAVAN_AXLE_COUNT("caravan_axle_count","License", "Чиргүүлийн тэнхлэг тоо", "r.kkkkkkk"),
//    TYPE("type", "License","төрөл", "r.kkkkkkk"),
//    FEE("fee", "License", "Хураамж", "r.kkkkkkk"),
//    RE_PRINT("re_print", "License", "Дахин хэвэлсэн", "r.kkkkkkk"),
//

//    FREIGHT_AMOUNT("freight_amount","ReportFreightData", "Нийт ачаа", "r.kkkkkkk");

    String id;
    String key;
    String name;
    String table;
    String value;

    ReportRequest(String key, String table,String name, String value) {
        this.id = key;
        this.key = key;
        this.name = name;
        this.table = table;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
    public String getTable(){return table; }
    public String getValue(){return value; }
    public String getId(){return id;}
}
