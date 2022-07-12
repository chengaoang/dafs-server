package com.sangeng.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sangeng.data.Comment;
import com.sangeng.data.Products;
import com.sangeng.domain.ResponseResult;
import com.sangeng.service.CommentService;
import com.sangeng.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ProductsService productsService;

    @PostMapping
    public ResponseResult<String> insertOne(@RequestBody Comment comment){
        commentService.save(comment);
        return new ResponseResult<String>(200,"",null);
    }

    @DeleteMapping("/{id}")
    public ResponseResult<String> delete(@PathVariable("id") Long id){
        commentService.removeById(id);
        return new ResponseResult<String>(200,"",null);
    }

    @PutMapping
    public ResponseResult<String> put(@RequestBody Comment comment){
        Comment foo = commentService.getById(comment.getId());
        foo.setContent(comment.getContent());
        commentService.updateById(foo);
        return new ResponseResult<String>(200,"修改成功咧",null);
    }

    @GetMapping
    public ResponseResult<List<Comment>> getAll(){
        List<Comment> list = commentService.list();
        for (Comment comment : list) {
            ResponseResult foo = productsService.getOneById(Math.toIntExact(comment.getPid()));
            Products p = (Products) foo.getData();
            String name = p.getName();
            comment.setProductName(name);
        }
        return new ResponseResult<>(200,"",list);
    }

    @GetMapping("/id/{id}") // 根据商品id查询评论
    public ResponseResult<Comment> get(@PathVariable Long id){
        Comment comment = commentService.getById(id);
        return new ResponseResult<>(200,"",comment);
    }

    @GetMapping("/{pid}") // 根据商品id查询评论
    public ResponseResult<List<Comment>> getOneByProductId(@PathVariable Long pid){
        List<Comment> list = commentService.list(Wrappers.<Comment>lambdaQuery().eq(Comment::getPid, pid));
        return new ResponseResult<>(200,"",list);
    }
}
