package com.sangeng;

import com.sangeng.domain.Menu;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.mapper.MenuMapper;
import com.sangeng.mapper.UserMapper;
import com.sangeng.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.URL;
import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void TestBCryptPasswordEncoder(){
        // $2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy
        // System.out.println(passwordEncoder.
        //         matches("1234",
        //                 "$2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy"));
       String encode = passwordEncoder.encode("1234");
       String encode2 = passwordEncoder.encode("1234");
       System.out.println(encode);
       System.out.println(encode2);

    }

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testSelectPermsByUserId(){
        List<String> list = menuMapper.selectPermsByUserId(1L);
        System.out.println(list);
    }


    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


//
    @Autowired
    private MenuService menuService;
    @Test
    public void testMenuService(){
        ResponseResult all = menuService.getAll();
        System.out.println(all);
        System.out.println("============================================");
        Menu menu = menuService.getMenuByName("删除栏目");
        System.out.println(menu);
    }

    @Value("${setting.upload}")
    private String path;
    @Test
    public void t02(){
        System.out.println(path);
    }


    @Test
    public void t01(){
        String property = System.getProperty("user.dir");
        System.out.println(property);
        //
    }
}
