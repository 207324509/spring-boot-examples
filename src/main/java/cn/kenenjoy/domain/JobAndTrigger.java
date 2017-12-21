package cn.kenenjoy.domain;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by hefa on 2017/12/21.
 */
public class JobAndTrigger implements Serializable {
    private static final long serialVersionUID = -1049139809899936764L;

    private String jobName;
    private String jobGroup;
    private String jobClassName;
    private String triggerName;
    private String triggerGroup;
    private BigInteger repeatInterval;
    private BigInteger timesTriggerd;
    private String cronExpression;
    private String timeZoneID;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public BigInteger getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(BigInteger repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public BigInteger getTimesTriggerd() {
        return timesTriggerd;
    }

    public void setTimesTriggerd(BigInteger timesTriggerd) {
        this.timesTriggerd = timesTriggerd;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneID() {
        return timeZoneID;
    }

    public void setTimeZoneID(String timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobAndTrigger that = (JobAndTrigger) o;

        if (jobName != null ? !jobName.equals(that.jobName) : that.jobName != null) return false;
        if (jobGroup != null ? !jobGroup.equals(that.jobGroup) : that.jobGroup != null) return false;
        if (jobClassName != null ? !jobClassName.equals(that.jobClassName) : that.jobClassName != null) return false;
        if (triggerName != null ? !triggerName.equals(that.triggerName) : that.triggerName != null) return false;
        if (triggerGroup != null ? !triggerGroup.equals(that.triggerGroup) : that.triggerGroup != null) return false;
        if (repeatInterval != null ? !repeatInterval.equals(that.repeatInterval) : that.repeatInterval != null)
            return false;
        if (timesTriggerd != null ? !timesTriggerd.equals(that.timesTriggerd) : that.timesTriggerd != null)
            return false;
        if (cronExpression != null ? !cronExpression.equals(that.cronExpression) : that.cronExpression != null)
            return false;
        return timeZoneID != null ? timeZoneID.equals(that.timeZoneID) : that.timeZoneID == null;
    }

    @Override
    public int hashCode() {
        int result = jobName != null ? jobName.hashCode() : 0;
        result = 31 * result + (jobGroup != null ? jobGroup.hashCode() : 0);
        result = 31 * result + (jobClassName != null ? jobClassName.hashCode() : 0);
        result = 31 * result + (triggerName != null ? triggerName.hashCode() : 0);
        result = 31 * result + (triggerGroup != null ? triggerGroup.hashCode() : 0);
        result = 31 * result + (repeatInterval != null ? repeatInterval.hashCode() : 0);
        result = 31 * result + (timesTriggerd != null ? timesTriggerd.hashCode() : 0);
        result = 31 * result + (cronExpression != null ? cronExpression.hashCode() : 0);
        result = 31 * result + (timeZoneID != null ? timeZoneID.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "JobAndTrigger{" +
                "jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobClassName='" + jobClassName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", repeatInterval=" + repeatInterval +
                ", timesTriggerd=" + timesTriggerd +
                ", cronExpression='" + cronExpression + '\'' +
                ", timeZoneID='" + timeZoneID + '\'' +
                '}';
    }
}
