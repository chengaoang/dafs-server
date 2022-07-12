package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorys")
public class CategoryControllerRest {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseResult getAll(){
        ResponseResult responseResult = categoryService.sellectAll();
        return responseResult;
    }
}
