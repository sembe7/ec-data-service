package mn.astvision.starter.api.ec;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.astvision.starter.api.request.antd.AntdPagination;
import mn.astvision.starter.api.response.antd.AntdTableDataList;
import mn.astvision.starter.dao.ec.LicenseDao;
import mn.astvision.starter.model.ec.License;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sembe
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/license")
public class LicenseApi {

    private final LicenseDao licenseDao;

    @GetMapping
    public ResponseEntity<?> list(String number, Integer year, Integer part, Boolean tax_paid, AntdPagination pagination) {
        AntdTableDataList<License> listData = new AntdTableDataList<>();
        try {
            pagination.setTotal(licenseDao.count(number, year, part, tax_paid));
            listData.setPagination(pagination);
            listData.setList(licenseDao.list(number, year, part, tax_paid, pagination.toPageRequest()));
        } catch (Exception e) {
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(listData);
    }
}
