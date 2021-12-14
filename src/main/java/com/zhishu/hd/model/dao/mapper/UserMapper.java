package com.zhishu.hd.model.dao.mapper;

import com.zhishu.hd.model.dao.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username='${username}' ")
    User selectByName(String username);
}