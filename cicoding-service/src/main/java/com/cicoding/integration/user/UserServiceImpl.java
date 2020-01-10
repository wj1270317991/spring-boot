package com.cicoding.integration.user;

import com.cicoding.integration.User;
import com.cicoding.integration.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * com.cicoding.integration.user
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/12/11.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String hi(){
        return "Hi";
    }

    @Override
    public List<User> getUsers() {
        List<String> list = new ArrayList<>();
        list.add("999");
        list.add("-999");
        List<User> users = userMapper.selectAll(list);
        return users;
    }
}
