package com.cicoding.integration.user;

import org.springframework.stereotype.Service;

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

    @Override
    public String hi(){
        return "Hi";
    }
}
