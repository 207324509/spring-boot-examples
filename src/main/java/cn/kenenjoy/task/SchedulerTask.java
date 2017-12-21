package cn.kenenjoy.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hefa on 2017/7/29.
 */
@Component
public class SchedulerTask {

//    private static final Logger log = LoggerFactory.getLogger(SchedulerTask.class);
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    private int count = 0;
//
//    @Scheduled(cron = "0/30 * * * * ?")
//    private void processCurrentTime1() {
//        log.info("this is scheduler task runing " + (count++)+"\t现在时间:" + dateFormat.format(new Date()));
//    }
//
//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime2() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }
}
