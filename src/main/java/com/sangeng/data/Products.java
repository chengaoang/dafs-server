package com.sangeng.data;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 产品表对应的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("data_products")
public class Products {
    private @TableId Long pid;
    private Long cid; // 多个产品对应一个栏目，多端加入一端的主键
    private Integer status; // 栏目状态：0正常，1停用
    private String name; // 产品名称
    private String images; // 商品对应的图片，用json记录图片名字
    private String desc; // 描述，考虑用json存
}
