package com.hushihai.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping("send")
    public String send(String msg){
        logger.info("生产者生产的消息："+msg);
        kafkaTemplate.send("test_topic", msg);
        return "success";
    }
}
