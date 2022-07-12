package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into sys_user (user_name,password) value (#{userName},#{password})")
    int reg(User user);


    @Insert("insert into sys_user_role (user_id, role_id) value (#{id},2)")
    void initRole(Long id);


    @Select("select count(*) from sys_user where user_name=#{userName}")
    Integer exist(User user);
}
