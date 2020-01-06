package com.cicoding.integration.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue myQueue() {
        return new Queue("myqueue");
    }


    @RabbitListener(queues = "myqueue")
    public void listen(Object in) {
        System.out.println("接收的信息为："+in.toString());
    }

}
