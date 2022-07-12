package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.data.Products;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductsMapper extends BaseMapper<Products> {
    List<Products> getAll();
    Products getOneById(Integer id);
    void insertOne(@Param("cid") Long cid, @Param("name") String name, @Param("images") String images, @Param("desc") String desc);
    int updateByPid(Products p);
    List<Products> limit(@Param("first")Integer first,@Param("second") Integer second);
    Integer getCount();
    List<Products> sellectProductBycategoryId(Integer cid);

    List<Products> sellectProductByUId(Integer uid);
}
