package com.example.demo.job;

import com.example.demo.service.ClockService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

// TODO-02.
// 스프링 빈을 선언하는 애너테이션을 사용합니다.
public class CronJob {

    private final ClockService clockService;

    public CronJob(ClockService clockService) {
        this.clockService = clockService;
    }

    // TODO-03. 매초마다 실행하는 cron expression 은 "* * * * * *" 입니다.
    // Application 시작 5초후 매초마다 printTime() 메서드를 실행하도록 스케줄링하는 애너테이션을 선언합니다.
    public void printTime() {
        Date now = clockService.getCurrentDate();
        System.out.println(Thread.currentThread().getName() + ", Time = " + now);
    }
}
