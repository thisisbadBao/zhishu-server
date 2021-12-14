package com.zhishu.hd.service.impl;

import com.zhishu.hd.model.dao.entity.User;
import com.zhishu.hd.model.dao.mapper.UserMapper;
import com.zhishu.hd.model.dto.Login;
import com.zhishu.hd.model.dto.Register;
import com.zhishu.hd.model.dto.Result;
import com.zhishu.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Object register(Register register) {
        User user = new User();
        user.setUsername(register.getUserName());
        if(userMapper.selectByName(user.getUsername()) != null){
            return new Result(1,"用户名已被注册",null);
        }else {
            user.setUseraddr(register.getUserAddr());
            user.setUsertel(register.getUserTel());
            user.setUserpassword(register.getUserPassword());
            user.setUserjuris(false);
            userMapper.insert(user);
            return new Result(200, "注册成功",null);
        }
    }

    @Override
    public Object login(Login login) {
        User user = userMapper.selectByName(login.getUserName());
        if(user == null){
            return new Result(2,"该用户不存在",null);
        }else if( !user.getUserpassword().equals( login.getUserPassword() ) ){

            return new Result(3,"密码不正确",null);
        }else {
            return new Result(200,"登陆成功",user);
        }
    }
}
