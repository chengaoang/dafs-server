package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.Role;
import com.sangeng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping
    public ResponseResult post(@RequestBody Role role){
        int i = roleService.post(role);
        int code = i>0?200:500;
        String msg = i>0?"添加成功":"添加失败";
        return new ResponseResult(code,msg,null);
    }
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id){
        int i = roleService.delete(id);
        int code = i>0?200:500;
        String msg = i>0?"删除成功":"删除失败";
        return new ResponseResult(code,msg,null);
    }
    @PutMapping
    public ResponseResult put(@RequestBody Role role){
        int i = roleService.put(role);
        int code = i>0?200:500;
        String msg = i>0?"修改成功":"修改失败";
        return new ResponseResult(code,msg,null);
    }
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id){
        Role role = roleService.getById(id);
        int code = role!=null?200:500;
        String msg = role!=null?"获取成功":"获取失败";
        return new ResponseResult(code,msg,role);
    }
    @GetMapping
    public ResponseResult getAll(){
        List<Role> list = roleService.getAll();
        int code = list!=null?200:500;
        String msg = list!=null?"获取成功":"获取失败";
        return new ResponseResult(code,msg,list);
    }
}
