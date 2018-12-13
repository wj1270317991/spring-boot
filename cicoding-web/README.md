## 特别提醒
redis
springboot2.0以后引用
       
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
        
redisTemplate泛型的使用在实现对象（ex:User），需要实现
Serializable接口，不然的话，是不能取到值的。        
