package com.wby;

import com.wby.job.MyJob;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootQuartzApplicationTests {
    @Autowired
    private Scheduler scheduler;

    @Test
    void creatJob() throws SchedulerException {

//        //1.创建任务详情
//        JobDetail jobDetail = JobBuilder
//                .newJob(MyJob.class)
//                .withIdentity("my-job","my-job-group")
//                .build();
//
//        //2.创建触发器
//        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("my-trigger", "my-trigger-group")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
//                .build();
//
//        //3.创建任务将任务数据存储到数据库
//        scheduler.scheduleJob(jobDetail,trigger);


        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("my-job", "my-job-group")
                .build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("my-trigger", "my-trigger-group")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println("添加定时任务成功");
    }

}
