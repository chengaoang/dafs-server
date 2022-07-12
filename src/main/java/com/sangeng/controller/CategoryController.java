package com.sangeng.controller;

import com.sangeng.data.Category;
import com.sangeng.domain.ResponseResult;
import com.sangeng.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/limit")
    public ResponseResult limit(@RequestParam("page")Integer page, @RequestParam("size")Integer size){
        return categoryService.limit(page,size);
    }

    @GetMapping("/category/select/{id}")
    public ResponseResult selectById(@PathVariable("id")Integer id){
        return categoryService.selectById(id);
    }

    @GetMapping("/category/{category}")
    public ResponseResult selectByCategory(@PathVariable("category")Integer cid){
        return null;
    }

    @PostMapping("/category/insert")
    public ResponseResult insert(@RequestBody Category category){
        return categoryService.insert(category);
    }

    @PutMapping("/category/update/{id}")
    public ResponseResult update(@PathVariable("id")Integer id,@RequestBody Category category){
        return categoryService.update(id, category);
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseResult delete(@PathVariable("id")Integer id){
        return categoryService.delete(id);
    }
}
