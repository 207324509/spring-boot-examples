package cn.kenenjoy.controller;

import cn.kenenjoy.domain.JobAndTrigger;
import cn.kenenjoy.domain.Result;
import cn.kenenjoy.quartz.scheduler.CronScheduler;
import cn.kenenjoy.service.JobAndTriggerService;
import com.google.gson.Gson;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hefa on 2017/12/21.
 */
@RequestMapping(value = "job")
@Controller
public class JobController {
    private static final Logger log = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobAndTriggerService jobAndTriggerService;

    @Autowired
    private CronScheduler cronScheduler;

    /**
     * 查询任务列表
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/queryJobs", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryJobs(int page, int rows) {
        log.debug("进入queryJobs");
        System.out.println("page" + page + "rows" + rows);
        List<JobAndTrigger> jobAndTriggers = jobAndTriggerService.getJobAndTriggerDetails(page, rows);
        String total = jobAndTriggerService.countJobAndTriggerDetails().toString();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", jobAndTriggers);
        Gson gson = new Gson();
        String result = gson.toJson(map);
        log.debug(result);
        return result;
    }

    /**
     * 添加任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @return
     */
    @RequestMapping(value = "/addJob", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addJob(String jobClassName, String jobGroupName, String cronExpression) {
        log.debug("进入queryJobs");
        Gson gson = new Gson();
        Result result = new Result();

        try {
            cronScheduler.addJob(jobClassName, jobGroupName, cronExpression);
            result.setSuccess("success");
        } catch (SchedulerException e) {
            log.error("添加Job发生异常：", e);
            result.setErrorMsg("添加Job报错" + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error("添加Job发生异常：", e);
            result.setErrorMsg("添加Job报错" + e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("添加Job发生异常：", e);
            result.setErrorMsg("添加Job报错" + e.getMessage());
        } catch (InstantiationException e) {
            log.error("添加Job发生异常：", e);
            result.setErrorMsg("添加Job报错" + e.getMessage());
        }
        return gson.toJson(result);
    }


    /**
     * 修改任务
     *
     * @return
     */
    @RequestMapping(value = "/rescheduleJob", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String rescheduleJob(String jobClassName, String jobGroupName, String cronExpression) {
        log.debug("进入rescheduleJob");
        Gson gson = new Gson();
        Result result = new Result();
        try {
            cronScheduler.rescheduleJob(jobClassName, jobGroupName, cronExpression);
            result.setSuccess("success");
        } catch (SchedulerException e) {
            log.error("修改Job异常:", e);
            result.setErrorMsg("修改Job报错" + e.getMessage());
        }
        return gson.toJson(result);
    }

    /**
     * 删除任务
     *
     * @return
     */
    @RequestMapping(value = "/deleteJob", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteJob(String jobClassName, String jobGroupName) {
        log.debug("进入deleteJob");
        Gson gson = new Gson();
        Result result = new Result();
        try {
            cronScheduler.delete(jobClassName, jobGroupName);
            result.setSuccess("success");
        } catch (SchedulerException e) {
            log.error("删除Job异常:", e);
            result.setErrorMsg("删除Job报错" + e.getMessage());
        }
        return gson.toJson(result);
    }


    /**
     * 暂停任务
     *
     * @return
     */
    @RequestMapping(value = "/pauseJob", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String pauseJob(String jobClassName, String jobGroupName) {
        log.debug("进入pauseJob");
        Gson gson = new Gson();
        Result result = new Result();
        try {
            cronScheduler.pauseJob(jobClassName, jobGroupName);
            result.setSuccess("success");
        } catch (SchedulerException e) {
            log.error("暂停Job异常:", e);
            result.setErrorMsg("暂停Job报错" + e.getMessage());
        }
        return gson.toJson(result);
    }

    /**
     * 恢复任务
     *
     * @return
     */
    @RequestMapping(value = "/resumeJob", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String resumeJob(String jobClassName, String jobGroupName) {
        log.debug("进入resumeJob");
        Gson gson = new Gson();
        Result result = new Result();
        try {
            cronScheduler.resumeJob(jobClassName, jobGroupName);
            result.setSuccess("success");
        } catch (SchedulerException e) {
            log.error("恢复Job异常:", e);
            result.setErrorMsg("恢复Job报错" + e.getMessage());
        }
        return gson.toJson(result);
    }


}
