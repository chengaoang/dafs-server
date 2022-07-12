package com.sangeng.controller;

import com.sangeng.domain.Menu;
import com.sangeng.domain.ResponseResult;
import com.sangeng.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    // 查看menu表的所有信息,要有select权限，
    @PreAuthorize("@ex.hasAuthority('menu:select')")
    @GetMapping("/menu/select")
    public ResponseResult getAll(){
        return menuService.getAll();
    }

    // menu表中增加一条信息,要有insert权限，
    @PreAuthorize("@ex.hasAuthority('menu:insert')")
    @PostMapping("/menu/insert")
    public ResponseResult insertOne(@RequestBody Menu menu){
        return menuService.insertOne(menu);
    }

    // menu表中删除一条信息,要有delete权限，
    @PreAuthorize("@ex.hasAuthority('menu:delete')")
    @GetMapping("/menu/delete/{id}")
    public ResponseResult deleteOneByID(@PathVariable("id") Integer menuId){
        return menuService.deleteOneByID(menuId);
    }
    // menu表中修改一条信息,要有update权限，
    @PreAuthorize("@ex.hasAuthority('menu:update')")
    @GetMapping("/menu/update")
    public ResponseResult updateMenu(@RequestBody Menu menu){
        return menuService.updateOne(menu);
    }

}
