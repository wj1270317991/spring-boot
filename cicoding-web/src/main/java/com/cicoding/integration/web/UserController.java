package com.cicoding.integration.web;

import com.cicoding.integration.UserRepository;
import com.cicoding.integration.pojo.User;
import com.cicoding.integration.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("list")
    public String list() {
        /*
        userRepository.save(new com.cicoding.integration.User("AAA",10));
        userRepository.save(new com.cicoding.integration.User("BBB", 20));
        userRepository.save(new com.cicoding.integration.User("CCC", 30));
        userRepository.save(new com.cicoding.integration.User("DDD", 40));
        userRepository.save(new com.cicoding.integration.User("EEE", 50));
        userRepository.save(new com.cicoding.integration.User("FFF", 60));
        userRepository.save(new com.cicoding.integration.User("GGG", 70));
        userRepository.save(new com.cicoding.integration.User("HHH", 80));
        userRepository.save(new com.cicoding.integration.User("III", 90));
        userRepository.save(new com.cicoding.integration.User("JJJ", 100));
        */
        List<com.cicoding.integration.User> all = userRepository.findAll();
        return null;
    }


    @ApiOperation(value="redis", notes="")
    @RequestMapping(value="redis", method= RequestMethod.POST)
    public String postUser() {
        redisTemplate.opsForValue().set("test","test",1000);
        String test = redisTemplate.opsForValue().get("test");
        return test;
    }




}
