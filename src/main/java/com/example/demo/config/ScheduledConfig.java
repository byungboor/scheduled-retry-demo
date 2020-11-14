package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

// TODO-01. 스케줄링 기능을 켜는 설정 Annotation 을 선언합니다.
@EnableScheduling
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setThreadNamePrefix("scheduler-job-");
        taskScheduler.setPoolSize(15);                                  // default 1, Job size..
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);        // Graceful Shutdown
        taskScheduler.setAwaitTerminationSeconds(60);                   // Graceful Shutdown
        taskScheduler.initialize();                                     // Thread Pool Init.

        taskRegistrar.setTaskScheduler(taskScheduler);
    }
}
