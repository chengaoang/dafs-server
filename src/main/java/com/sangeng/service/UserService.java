package com.sangeng.service;

import com.sangeng.controller.WebSocket;
import com.sangeng.domain.User;
import com.sangeng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int post(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    public int delete(Long id) {
        int i = userMapper.deleteById(id);
        return i;
    }

    public int put(User user) {
        int i = userMapper.updateById(user);
        return i;
    }

    public User getById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }

    public List<User> getAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    public Integer getCount() {
        Integer integer = userMapper.selectCount(null);
        return integer;
    }

    public Integer getOnelineCount() {
        int size = WebSocket.SESSIONS.size();
        return size;
    }
}
