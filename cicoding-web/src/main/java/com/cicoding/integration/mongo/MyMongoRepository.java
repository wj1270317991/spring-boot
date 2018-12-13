package com.cicoding.integration.mongo;

import com.cicoding.integration.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * com.cicoding.integration.mongo
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/12/13.
 */


public interface MyMongoRepository extends MongoRepository<User,Long> {
    
}
