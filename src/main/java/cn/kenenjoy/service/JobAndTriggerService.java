package cn.kenenjoy.service;

import cn.kenenjoy.domain.JobAndTrigger;

import java.util.List;

/**
 * Created by hefa on 2017/12/21.
 */
public interface JobAndTriggerService {
    /**
     * 查询任务列表
     * @param page
     * @param rows
     * @return
     */
    List<JobAndTrigger> getJobAndTriggerDetails(int page,int rows);

    /**
     * 统计任务个数
     * @return
     */
    Integer countJobAndTriggerDetails();
}
