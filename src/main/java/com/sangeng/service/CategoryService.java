package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.data.Category;
import com.sangeng.data.Products;
import com.sangeng.domain.ResponseResult;
import com.sangeng.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper,Category> {

    @Autowired
    private CategoryMapper categoryMapper;

    public ResponseResult sellectAll() {
        return new ResponseResult(200,categoryMapper.sellectAll());
    }

    public ResponseResult limit(Integer page, Integer size){
        Integer count = categoryMapper.getCount();
        List<Category> list = categoryMapper.limit((page-1)*size, size);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("count",count);
        hashMap.put("category",list);
        return new ResponseResult(200, hashMap);
    }

    public ResponseResult selectById(Integer id){
        return new ResponseResult(200, categoryMapper.getOneById(id));
    }

    public ResponseResult insert(Category category) {
        String path = category.getPath();
        String name = category.getName();
        String desc = category.getDesc();
        Long createBy = category.getCreateBy();
        Date created = category.getCreated();
        Long updateBy = category.getUpdateBy();
        Date updated = category.getUpdated();
        Integer status = category.getStatus();
        categoryMapper.insert(path,name,desc,createBy,created,updateBy,updated,status);
        return new ResponseResult(200,"");
    }

    public ResponseResult update(Integer id, Category category) {
        category.setId(Long.valueOf(id));
        System.out.println("修改了："+category);
        int i = categoryMapper.update(category);
        return new ResponseResult(200,"修改了"+i+"条数据！");
    }


    public ResponseResult delete(Integer id) {
        int i = categoryMapper.deleteById(id);
        return new ResponseResult(200,"删除了"+i+"条数据！");
    }

    public Integer getCount(){
        Integer count = categoryMapper.getCount();
        return count;
    }


}
