package com.fitness.service;

import com.fitness.model.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {



    @RabbitListener(queues = "activity.queue")
    public void processActivity(Activity activity){
        log.info("Received Activity for Processing: {}",activity.getId());
    }

}
