package mn.astvision.starter.api.ec;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.astvision.starter.api.response.BaseResponse;
import mn.astvision.starter.model.auth.User;
import mn.astvision.starter.model.ec.City;
import mn.astvision.starter.model.ec.District;
import mn.astvision.starter.model.ec.ProductCategory;
import mn.astvision.starter.repository.ec.CityRepository;
import mn.astvision.starter.repository.ec.DistrictRepository;
import mn.astvision.starter.repository.ec.ProductCategoryRepository;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Sembe
 */
@Slf4j
//@Secured("ROLE_FAQ_MANAGE")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ecData")
public class getDataApi {
//    localhost:8080/report/json/list

//    @Value("${ecTrans.baseUrl}")
    private String baseUrl;

    private RestTemplate restTemplate;
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @PostConstruct
    public void setup() {
        restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);

        // enable logging when needed
//        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//        interceptors.add(new LoggingRequestInterceptor(log));
//        restTemplate.setInterceptors(interceptors);
    }

    @RequestMapping("city")
    public BaseResponse saveCity() {
        BaseResponse response = new BaseResponse();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            String sql = "SELECT * FROM city";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            List<City> cityList = new ArrayList<>();
            for (Map<String, Object> map : list) {
                City city = new City();
                city.setId((Integer) map.get("id"));
                city.setName((String) map.get("name"));

                System.out.println("map " + map.get("name"));
                cityRepository.save(city);
                cityList.add(city);
            }
            response.setData(cityList);
            response.setResult(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return response;
    }

    @RequestMapping("district")
    public BaseResponse saveDistrict() {
        BaseResponse response = new BaseResponse();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            String sql = "SELECT * FROM district";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            List<District> districtList = new ArrayList<>();
            for (Map<String, Object> map : list) {
                District district = new District();
                district.setId((Integer) map.get("id"));
                district.setName((String) map.get("name"));
                district.setCity_id((Integer) map.get("city_id"));

                districtRepository.save(district);
                districtList.add(district);
            }
            response.setData(districtList);
            response.setResult(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return response;
    }

    @RequestMapping("productCategory")
    public BaseResponse saveProductCategory() {
        BaseResponse response = new BaseResponse();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            String sql = "SELECT * FROM product_category";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            List<ProductCategory> productCategoryList = new ArrayList<>();
            for (Map<String, Object> map : list) {
                ProductCategory productCategory = new ProductCategory();
                productCategory.setId((Integer) map.get("id"));
                productCategory.setName((String) map.get("name"));
                productCategory.setParent_id((Integer) map.get("parent_id"));

                productCategoryRepository.save(productCategory);
                productCategoryList.add(productCategory);
            }
            response.setData(productCategoryList);
            response.setResult(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return response;
    }

    private HttpHeaders generateHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @RequestMapping("getDataWithMySql")
    public BaseResponse getDataWithMySql() {
////        String url = "jdbc:mysql://127.0.0.1/ntg_license?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&useSSL=false";
//        String username = "vehicle_license";
//        String password = "_asT^_$_velic";
//        String url = "jdbc:mysql://10.3.101.122/ntg?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&useSSL=false";
//
//        System.out.println("getDataWithMySql " + url);
        BaseResponse response = new BaseResponse();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            String sql = "SELECT * FROM city";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            List<City> cityList = new ArrayList<>();
            for (Map<String, Object> map : list) {
                City city = new City();
                city.setId((Integer) map.get("id"));
                city.setName((String) map.get("name"));

                System.out.println("map " + map.get("name"));
                cityRepository.save(city);
                cityList.add(city);
            }
            response.setData(cityList);
            response.setResult(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return response;
    }

}
