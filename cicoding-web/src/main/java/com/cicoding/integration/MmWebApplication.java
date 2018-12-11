package com.cicoding.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * com.cicoding.integration
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/12/11.
 */

@SpringBootApplication
//@ComponentScan({"com.cicoding.integration"})
public class MmWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmWebApplication.class, args);
    }
}