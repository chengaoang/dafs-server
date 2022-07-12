package com.sangeng.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userReg {
    @Autowired
    private UserMapper userMapper;

    public ResponseResult reg(User user){
        int i = userMapper.reg(user);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserName,user.getUserName());
        User one = userMapper.selectOne(lambdaQueryWrapper);
        userMapper.initRole(one.getId());
        return new ResponseResult(200,"注册了"+i+"位用户！");
    }

    public boolean exist(User user){
        Integer exist = userMapper.exist(user);
        return exist > 0;
    }
}
