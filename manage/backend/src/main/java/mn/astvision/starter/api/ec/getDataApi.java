package mn.astvision.starter.api.ec;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.astvision.starter.api.response.BaseResponse;
import mn.astvision.starter.model.auth.User;
import mn.astvision.starter.model.ec.City;
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

    @RequestMapping("getData")
    public BaseResponse sendEcData() {
        System.out.println("getData " + baseUrl);
        BaseResponse response = new BaseResponse();
//        Report requestData = new Report();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Object> entity = new HttpEntity<>(headers);

        System.out.println("getData 01" );
        try {
//            Map<String, Object> vars = new HashMap<String, Object>();
//            System.out.println("booking ");
//            restTemplate.getForObject(baseUrl, Object.class, vars);
            System.out.println("yAeaaaaaah ");
            ResponseEntity<BaseResponse> responseEntity = restTemplate.exchange(
                    baseUrl,
                    HttpMethod.GET,
                    entity,
                    BaseResponse.class);
            System.out.println("getData 2 ");
            if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value() && responseEntity.getBody() != null) {
                response.setData(responseEntity.getBody());
                response.setResult(true);
            }
        } catch (HttpClientErrorException e) {
            System.out.println("getData catch " + e.getMessage() );
            log.error(e.getMessage(), e);
            response.setResult(false);
            response.setMessage(e.getMessage());
        } catch (HttpStatusCodeException exception) {
            System.out.println("error catch " + exception.getMessage() );
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
//        String url = "jdbc:mysql://127.0.0.1/ntg_license?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&useSSL=false";
        String username = "vehicle_license";
        String password = "_asT^_$_velic";
        String url = "jdbc:mysql://10.3.101.122/ntg?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&useSSL=false";

        System.out.println("getDataWithMySql " + url);
        BaseResponse response = new BaseResponse();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            String sql = "SELECT * FROM city";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            List<City> cityList = new ArrayList<>();
            for (Map<String, Object> map : list) {
                System.out.println("map " + map.get("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return response;
    }

}
