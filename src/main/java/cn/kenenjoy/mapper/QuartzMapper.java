package cn.kenenjoy.mapper;

import cn.kenenjoy.domain.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hefa on 2017/12/21.
 */
@Repository
@Mapper
public interface QuartzMapper {
    @Select("SELECT qrtz_job_details.JOB_NAME as jobName, qrtz_job_details.JOB_GROUP as jobGroup, qrtz_job_details.JOB_CLASS_NAME as jobClassName, qrtz_triggers.TRIGGER_NAME as triggerName, qrtz_triggers.TRIGGER_GROUP triggerGroup, qrtz_cron_triggers.CRON_EXPRESSION as cronExpression, qrtz_cron_triggers.TIME_ZONE_ID as timeZoneID FROM qrtz_job_details JOIN qrtz_triggers JOIN qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME AND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME AND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP order by qrtz_job_details.JOB_NAME limit #{page}, #{rows} ")
    List<JobAndTrigger> getJobAndTriggerDetails(@Param("page") int page, @Param("rows") int rows);

    @Select("SELECT COUNT(qrtz_job_details.JOB_NAME) FROM qrtz_job_details JOIN qrtz_triggers JOIN qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME AND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME AND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP")
    Integer countJobAndTriggerDetails();
}
