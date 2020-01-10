package com.cicoding.integration.mapper;

import com.cicoding.integration.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * ddd
     * @param lists
     * @return
     */
    List<User> selectAll(@Param("lists") List<String> lists);
}
