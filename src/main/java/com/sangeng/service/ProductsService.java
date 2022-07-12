package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.data.Products;
import com.sangeng.domain.ResponseResult;
import com.sangeng.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductsService extends ServiceImpl<ProductsMapper, Products> {
    @Autowired
    private ProductsMapper productsMapper;

    public ResponseResult getAll(){
        Integer count = productsMapper.getCount();
        List<Products> all = productsMapper.getAll();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("count",count);
        hashMap.put("products",all);
        return new ResponseResult(200, hashMap);
    }

    public ResponseResult getOneById(Integer id){
        return new ResponseResult(200, productsMapper.getOneById(id));
    }

    public ResponseResult insertProduct(Products p) {
        Long cid = p.getCid();
        String name = p.getName();
        String images = p.getImages();
        String desc = p.getDesc();
        productsMapper.insertOne(cid,name,images,desc);
        return new ResponseResult(200,"");
    }

    public ResponseResult updateProduct(Integer id, Products p) {
        p.setPid(Long.valueOf(id));
        System.out.println("修改了："+p);
        int i = productsMapper.updateByPid(p);
        return new ResponseResult(200,"修改了"+i+"条数据！");
    }


    public ResponseResult deleteProduct(Integer id) {
        int i = productsMapper.deleteById(id);
        return new ResponseResult(200,"删除了"+i+"条数据！");
    }

    public ResponseResult limit(Integer per, Integer page) {
        List<Products> list = productsMapper.limit((page-1)*per, per);
        Integer count = productsMapper.getCount();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("count",count);
        hashMap.put("products",list);
        return new ResponseResult(200,hashMap);
    }

    public Integer getCount(){
        Integer count = productsMapper.getCount();
        return count;
    }


    public ResponseResult sellectProductBycategoryId(Integer cid) {
        List<Products> list = productsMapper.sellectProductBycategoryId(cid);
        return new ResponseResult(200,list);
    }

    public ResponseResult sellectProductByUId(Integer uid) {
        List<Products> list = productsMapper.sellectProductByUId(uid);
        return new ResponseResult(200, list);
    }
}
