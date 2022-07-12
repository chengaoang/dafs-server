package com.sangeng.service;

import com.sangeng.domain.Role;
import com.sangeng.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public int post(Role role) {
        int insert = roleMapper.insert(role);
        return insert;
    }

    public int delete(Integer id) {
        int i = roleMapper.deleteById(id);
        return i;
    }

    public int put(Role role) {
        int i = roleMapper.updateById(role);
        return i;
    }

    public Role getById(Integer id) {
        Role role = roleMapper.selectById(id);
        return role;
    }

    public List<Role> getAll() {
        List<Role> roles = roleMapper.selectList(null);
        return roles;
    }
}
