package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClockService {

    @Autowired
    private ClockService self;

    public Date getCurrentDate() {
        if (true)
            throw new RuntimeException("Hahahah");

        return new Date();
    }

    // TODO 02 RuntimeException 에만 Retry 를 할 수 있도록 애너테이션을 정의합니다.
    public Date fetchCurrentDate() {
        System.out.println("----------------------- fetch ! date!");
        return self.getCurrentDate();
    }

    // TODO 03 - retry 의 횟수를 초과하면 처리할 메서드입니다. fallback 을 위해서 애너테이션을 정의합니다.
    public Date fallback() {
        System.out.println("======================= fallback");
        return new Date();
    }
}
