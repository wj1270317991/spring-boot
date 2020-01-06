package com.cicoding.integration.web;

import com.cicoding.integration.UserRepository;
import com.cicoding.integration.mongo.MyMongoRepository;
import com.cicoding.integration.pojo.User;
import com.cicoding.integration.user.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.experimental.Accessors;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * com.cicoding.integration.web
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/12/11.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;


    @Autowired
    private MyMongoRepository myMongoRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @ApiOperation(value = "db", notes = "")
    @GetMapping("list")
    public List list(Map map) {
        userRepository.save(new com.cicoding.integration.User("AAA", 10));
        userRepository.save(new com.cicoding.integration.User("BBB", 20));
        userRepository.save(new com.cicoding.integration.User("CCC", 30));
        userRepository.save(new com.cicoding.integration.User("DDD", 40));
        userRepository.save(new com.cicoding.integration.User("EEE", 50));
        userRepository.save(new com.cicoding.integration.User("FFF", 60));
        userRepository.save(new com.cicoding.integration.User("GGG", 70));
        userRepository.save(new com.cicoding.integration.User("HHH", 80));
        userRepository.save(new com.cicoding.integration.User("III", 90));
        userRepository.save(new com.cicoding.integration.User("JJJ", 100));

        List<com.cicoding.integration.User> all = userRepository.findAll();
        return all;
    }


    @ApiOperation(value = "redis", notes = "")
    @RequestMapping(value = "redis", method = RequestMethod.POST)
    public String postUser() {
        User dddd = new User("dddd", 1);
        redisTemplate.opsForValue().set("aaaaaaa", dddd);
        User aaaaaaa = redisTemplate.opsForValue().get("aaaaaaa");
        return aaaaaaa.toString();
    }


    @ApiOperation(value = "mongo", notes = "")
    @RequestMapping(value = "mongo", method = RequestMethod.POST)
    public String mongo() {
        // 创建三个User，并验证User总数
        myMongoRepository.save(new User("ni", 30));
        myMongoRepository.save(new User("mama", 40));
        myMongoRepository.save(new User("kaka", 50));
        List<User> all = myMongoRepository.findAll();
        return null;
    }

    /**
     * rabbitmq 简单模式
     * @return
     */
    @ApiOperation(value = "rabbitmq", notes = "")
    @RequestMapping(value = "rabbitmq", method = RequestMethod.POST)
    public String rabbitmq() throws Exception{
        while (true) {
            Thread.sleep(1000);
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "test message, hello!";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", messageId);
            map.put("messageData", messageData);
            map.put("createTime", createTime);
            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
            rabbitTemplate.convertAndSend("myqueue", map);
        }
    }


    /**
     * rabbitmq2 topic模式
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "rabbitmq2", notes = "")
    @RequestMapping(value = "rabbitmq2", method = RequestMethod.POST)
    public String rabbitmq2() throws Exception{
        rabbitTemplate.convertAndSend("topic-queue-exchange","order.log.info","order info send ...");
        rabbitTemplate.convertAndSend("topic-queue-exchange","order.log.warn","order warn send ...");
        rabbitTemplate.convertAndSend("topic-queue-exchange","sku.log.info","sku info send ...");
        rabbitTemplate.convertAndSend("topic-queue-exchange","sku.log.warn","sku warn send ...");
        return null;
    }



}
