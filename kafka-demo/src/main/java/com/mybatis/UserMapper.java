package com.mybatis;

import com.mybatis.demo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select  * from user where id = #{id}")
    public User selectUser(Integer id);
}
