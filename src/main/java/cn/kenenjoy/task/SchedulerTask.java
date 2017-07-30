package cn.kenenjoy.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hefa on 2017/7/29.
 */
@Component
public class SchedulerTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int count = 0;

    @Scheduled(cron = "0 */1 * * * ?")
    private void processCurrentTime() {
        System.out.println("this is scheduler task runing " + (count++)+"\t现在时间:" + dateFormat.format(new Date()));
    }
}
