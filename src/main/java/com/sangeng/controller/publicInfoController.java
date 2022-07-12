package com.sangeng.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sangeng.domain.Menu;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.mapper.MenuMapper;
import com.sangeng.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class publicInfoController {
    // /public 用来 暴漏表的公共资源
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private userReg userReg;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/public/menu/select")
    public ResponseResult menuNames(){
        List<String> list = new ArrayList<>();
        List<Menu> all = menuMapper.selectList(null);
        for (Menu menu : all) {
            list.add(menu.getMenuName());
        }
        return new ResponseResult(200, list);
    }
    //

    @PostMapping("/public/file/upload")
    public ResponseResult upload(@RequestParam("images") MultipartFile file){
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        // String storeFileName = UUID.randomUUID()+suffix;
        String storeFileName = IdWorker.getId(filename) + suffix; // mp 的雪花算法
        File aFile = new File("/upload/img/" + storeFileName);
        if (!aFile.getParentFile().exists()){
            System.out.println("文件夹不存在："+aFile.getParentFile().getAbsolutePath());
            aFile.getParentFile().mkdirs();
        }
        try {
            // https://blog.csdn.net/qq_35746739/article/details/104508412 fixException
            file.transferTo(aFile); // 存文件
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseResult(200, "/img/"+storeFileName); // 前端写死了/img/filename吗，，先用着把??
    }

    @GetMapping("/img/{fileName}")
    public ResponseResult download(@PathVariable("fileName") String fileName, HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        String imgPath = System.getProperty("user.dir")+"/src/main/java/com/upload/img/";
        File img = new File(imgPath,fileName);
        FileInputStream fileInputStream = new FileInputStream(img);
        byte[] buffer = new byte[1024 * 8];
        int len;
        while ((len=fileInputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        outputStream.close();
        fileInputStream.close();
        return new ResponseResult(200,"下载图片over！");
    }

    @GetMapping("/public/products/count")
    public ResponseResult getCountProductsNumber(){
        return new ResponseResult(200,productsService.getCount());
    }

    @GetMapping("/public/category")
    public ResponseResult categoryGetAll(){
        return categoryService.sellectAll();
    }

    @GetMapping("/public/products/{categoryId}")
    public ResponseResult selectProductsBycategoryId(@PathVariable("categoryId")Integer cid){
        return productsService.sellectProductBycategoryId(cid);
    }

    @PostMapping("/public/user/reg")
    public ResponseResult regUser(@RequestBody User user){
        boolean exist = userReg.exist(user);
        if (exist) return new ResponseResult(400,"此用户已经存在！");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userReg.reg(user);
        return new ResponseResult(200,"注册成功");
    }

}
