package com.wby.scheduled;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyScheduled {
    @Scheduled(cron = "0/2 * * * * *")
    public void what(){
        System.out.println(new Date());
    }
}
