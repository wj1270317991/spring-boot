package com.cicoding.integration;

import org.springframework.data.jpa.repository.JpaRepository;


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
public interface UserRepository extends JpaRepository<User,Long>{
    @Override
    User getOne(Long aLong);

}
