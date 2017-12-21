package cn.kenenjoy.quartz.scheduler;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 任务持久化
 * Created by hefa on 2017/12/21.
 */
@Repository
public class CronScheduler {
    @Autowired
    private Scheduler scheduler;

    /**
     * 添加任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @throws SchedulerException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void addJob(String jobClassName, String jobGroupName, String cronExpression) throws SchedulerException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 启动调度器
        scheduler.start();

        Class<Job> class1 = (Class<Job>) Class.forName(jobClassName);
        // 构建job信息
        JobDetail jobDetail = JobBuilder.newJob(class1.newInstance().getClass()).withIdentity(jobClassName, jobGroupName).build();

        // 表达式调度构建器（任务运行时间）
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName).withSchedule(scheduleBuilder).build();
        // 先删除已存在，防止重复
        scheduler.deleteJob(new JobKey(jobClassName, jobGroupName));
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    /**
     * 修改任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @throws SchedulerException
     */
    public void rescheduleJob(String jobClassName, String jobGroupName, String cronExpression) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(jobClassName, jobGroupName);
        // 表达式调度构建器（任务运行时间）
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, cronTrigger);
    }

    /**
     * 删除任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @throws SchedulerException
     */
    public void delete(String jobClassName, String jobGroupName) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    /**
     * 暂停任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @throws SchedulerException
     */
    public void pauseJob(String jobClassName, String jobGroupName) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
    }


    /**
     * 恢复任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @throws SchedulerException
     */
    public void resumeJob(String jobClassName, String jobGroupName) throws SchedulerException {
        scheduler.resumeJob(new JobKey(jobClassName, jobGroupName));
    }


}
