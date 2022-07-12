package com.sangeng.controller;

import com.sangeng.data.Products;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.mapper.ProductsMapper;
import com.sangeng.service.ProductsService;
import com.sangeng.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    //
    @GetMapping("/products/collection")
    public ResponseResult selectProductsByUId(@RequestHeader String token) throws Exception {
        Claims claims = JwtUtil.parseJWT(token);
        Integer userid = Integer.valueOf(claims.getSubject());
        ResponseResult products = productsService.sellectProductByUId(userid);
        return products;
    }
    //===============
    @GetMapping("/products/select") // 默认是啥权限都行
    public ResponseResult getAll(){

        return productsService.getAll();
    }

    @GetMapping("/products/limit")
    public ResponseResult limit(@RequestParam("per")Integer per,@RequestParam("page")Integer page){
        /**
         * select * from data_products limit 1,2;
         * per 每一页显示的数量
         * page 当前页码
         * category 分类id TODO
         */
        return productsService.limit(per, page);
    }

    @GetMapping("/products/select/{id}")
    public ResponseResult getOneById(@PathVariable("id")Integer id){

        return productsService.getOneById(id);
    }

    @PostMapping("/products/insert")
    public ResponseResult<String> insertProduct(@RequestBody Products p){
        p.setStatus(1);
        productsService.save(p);
        return new ResponseResult<String>(200,"新增成功！","");
    }

    @PutMapping("/products/update/{id}")
    public ResponseResult updateProduct(@PathVariable("id")Integer id,@RequestBody Products p){
        return productsService.updateProduct(id, p);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseResult deleteProduct(@PathVariable("id")Integer id){
        return productsService.deleteProduct(id);
    }
}
