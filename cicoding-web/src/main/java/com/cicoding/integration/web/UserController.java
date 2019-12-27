package com.cicoding.integration.web;

import com.cicoding.integration.UserRepository;
import com.cicoding.integration.mongo.MyMongoRepository;
import com.cicoding.integration.pojo.User;
import com.cicoding.integration.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


}
