package com.sangeng.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.data.Category;
import com.sangeng.data.Products;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {
    Integer getCount();

    List<Category> limit(@Param("first")Integer page,@Param("second")Integer size);

    Category getOneById(Integer id);

    void insert(String name,String path, String desc, Long createBy, Date created, Long updateBy, Date updated, Integer status);

    int update(Category category);

    List<Category> sellectAll();
}
