package com.cicoding.integration.config;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "${spring.rabbitmq.config.queue.warn}",autoDelete = "false"),
        exchange=@Exchange(value = "${spring.rabbitmq.config.queue.exchange}",type = ExchangeTypes.TOPIC),
        key = "*.log.warn")})
public class RabbitListenWarnTopic {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Warn ............receiver" +msg);
    }
}
