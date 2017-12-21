package cn.kenenjoy.service.impl;

import cn.kenenjoy.domain.JobAndTrigger;
import cn.kenenjoy.mapper.QuartzMapper;
import cn.kenenjoy.service.JobAndTriggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hefa on 2017/12/21.
 */
@Service
public class JobAndTriggerServiceImpl implements JobAndTriggerService {
    private static final Logger log = LoggerFactory.getLogger(JobAndTriggerServiceImpl.class);

    @Autowired
    private QuartzMapper quartzMapper;

    @Cacheable(value = "jobAndTriggerDetails")
    @Override
    public List<JobAndTrigger> getJobAndTriggerDetails(int page, int rows) {
        log.debug("getJobAndTriggerDetails 查询数据库");
        return quartzMapper.getJobAndTriggerDetails((page - 1) * rows, rows);
    }

    @Cacheable(value = "jobAndTriggerDetails")
    @Override
    public Integer countJobAndTriggerDetails() {
        log.debug("countJobAndTriggerDetails 查询数据库");
        return quartzMapper.countJobAndTriggerDetails();
    }
}
