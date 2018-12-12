package com.cicoding.integration.web;

import com.cicoding.integration.UserRepository;
import com.cicoding.integration.pojo.User;
import com.cicoding.integration.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="/", method= RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        return "1111";
    }

}
