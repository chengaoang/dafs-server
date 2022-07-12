package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.service.UserService;
import com.sangeng.utils.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/whoami")
    public ResponseResult whoami(){
        Long id = BaseContext.get();
        User user = userService.getById(id);
        System.out.println(user);
        return new ResponseResult(200,"获取成功",user);
    }
    @PostMapping
    public ResponseResult post(@RequestBody User user){
        user.setUserType("2"); // 默认普通用户
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int i = userService.post(user);
        int code = i>0?200:500;
        String msg = i>0?"添加成功":"添加失败";
        return new ResponseResult(code,msg,null);
    }
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Long id){
        int i = userService.delete(id);
        int code = i>0?200:500;
        String msg = i>0?"删除成功":"删除失败";
        return new ResponseResult(code,msg,null);
    }
    @PutMapping
    public ResponseResult put(@RequestBody User user){
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int i = userService.put(user);
        int code = i>0?200:500;
        String msg = i>0?"修改成功":"修改失败";
        return new ResponseResult(code,msg,null);
    }
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        int code = user!=null?200:500;
        String msg = user!=null?"获取成功":"获取失败";
        return new ResponseResult(code,msg,user);
    }
    @GetMapping
    public ResponseResult getAll(){
        List<User> list = userService.getAll();
        int code = list!=null?200:500;
        String msg = list!=null?"获取成功":"获取失败";
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            list.set(i,user);
        }
        return new ResponseResult(code,msg,list);
    }

    @GetMapping("/info")
    public ResponseResult UserInfo(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("count",userService.getCount());
        hashMap.put("online",userService.getOnelineCount());
        return new ResponseResult(200,hashMap);
    }

}
