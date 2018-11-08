package cn.kenenjoy.configuration.quartz;

import cn.kenenjoy.domain.User;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by hefa on 2017/12/12.
 */
@Configuration
public class SchedulerConfig {

    @Autowired
    private AutowiringQuartzJobFactory jobFactory;

    @Bean
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        Properties properties = quartzProperties();
        properties.remove("org.quartz.jobStore.dataSource");
        properties.remove("org.quartz.dataSource.druid.connectionProvider.class");
        properties.remove("org.quartz.dataSource.druid.driverClassName");
        properties.remove("org.quartz.dataSource.druid.url");
        properties.remove("org.quartz.dataSource.druid.username");
        properties.remove("org.quartz.dataSource.druid.password");
        properties.remove("org.quartz.dataSource.druid.initialSize");
        properties.remove("org.quartz.dataSource.druid.minIdle");
        properties.remove("org.quartz.dataSource.druid.maxActive");
        properties.remove("org.quartz.dataSource.druid.validationQuery");
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(dataSource());
        schedulerFactoryBean.setQuartzProperties(properties);

        // 启动时更新已存在的Job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setJobFactory(jobFactory);
        return schedulerFactoryBean;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    /**
     * quartz初始化监听器
     *
     * @return
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        Scheduler scheduler = schedulerFactoryBean().getScheduler();
        scheduler.setJobFactory(jobFactory);
        return scheduler;
    }

}
