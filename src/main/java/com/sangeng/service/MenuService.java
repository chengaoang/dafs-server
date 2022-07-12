package com.sangeng.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sangeng.domain.Menu;
import com.sangeng.domain.ResponseResult;
import com.sangeng.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    // select
    public ResponseResult getAll(){
        return new ResponseResult(200, menuMapper.selectList(null));
    }

    // inesrt
    public ResponseResult insertOne(Menu menu){
        int insert = menuMapper.insert(menu);
        return new ResponseResult(200,"插入成功："+insert);
    }

    // delete
    public ResponseResult deleteOneByID(Integer id){
        int i = menuMapper.deleteById(id);
        return new ResponseResult(200, "删除成功："+i);
    }

    // update
    public ResponseResult updateOne(Menu menu){
        int i = menuMapper.updateById(menu);
        return new ResponseResult<>(200,"更新成功："+i);
    }


    public Menu getMenuByName(String menuName){
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getMenuName, menuName);
        Menu menu = menuMapper.selectOne(wrapper);
        if (Objects.isNull(menu)){
            throw new RuntimeException("没找到这个菜单名字");
        }
        return menu;
    }
}
