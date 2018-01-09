package cn.kenenjoy.controller;

import cn.kenenjoy.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hefa on 2018/1/9.
 */
@RequestMapping("/rest")
@RestController
public class ResetController {
    private static final Logger log = LoggerFactory.getLogger(ResetController.class);

    @RequestMapping("/greeting")
    public Result greeting(String name) {
        log.info("name:" + name);
        Result result = new Result();
        result.setSuccess("success");
        result.setErrorMsg("未报错!");
        return result;
    }
}
