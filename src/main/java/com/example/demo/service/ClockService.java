package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClockService {

    public Date getCurrentDate() {
        return new Date();
    }
}
