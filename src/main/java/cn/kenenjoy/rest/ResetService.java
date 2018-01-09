package cn.kenenjoy.rest;

import cn.kenenjoy.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hefa on 2018/1/9.
 */
@Service
public class ResetService {

    private static final Logger log = LoggerFactory.getLogger(ResetService.class);
    private final RestTemplate restTemplate;

    public ResetService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Result someRestCall(String name) {
        log.info("参数name：" + name);
        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("value", name);
        return this.restTemplate.getForObject("http://127.0.0.1:8080/rest/greeting?name={value}", Result.class, uriVariables);
    }


}
