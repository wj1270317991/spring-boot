package com.cicoding.integration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cicoding.integration.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * com.cicoding.integration
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/12/12.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;


//    @Before
//    public void setUp() {
//        jdbcTemplate1.update("DELETE  FROM  USER ");
//        jdbcTemplate2.update("DELETE  FROM  USER ");
//    }
//
//    @Test
//    public void test() throws Exception {
//    // 往第一个数据源中插入两条数据
//        jdbcTemplate1.update("insert into user(name,age) values( ?, ?)",  "aaa", 20);
//        jdbcTemplate1.update("insert into user(name,age) values( ?, ?)",  "bbb", 30);
//
//    // 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
//        jdbcTemplate2.update("insert into user(name,age) values( ?, ?)", "aaa", 20);
//
//    // 查一下第一个数据源中是否有两条数据，验证插入是否成功
//        Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));
//
//    // 查一下第一个数据源中是否有两条数据，验证插入是否成功
//        Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));
//    }

    @Test
    public void test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        int age = new Person().age();
        Person p = new Person().age(22);
        Person lisi = new Person().age(11).name("lisi");
        Object o = JSONObject.toJSON(lisi);
        Person person = new Person();

        System.out.println(JSONObject.toJSON(person));
    }

    @Test
    public void test04(){
        Map< String , Object > jsonMap = new HashMap< String , Object>();
        jsonMap.put("a",111);
        jsonMap.put("b","aaa");
        jsonMap.put("c",null);
        jsonMap.put("d","blog.csdn.net/moshowgame");
        String s = JSONObject.toJSONString(jsonMap);
        System.out.println(s);
    }
}
