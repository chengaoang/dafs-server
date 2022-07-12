package com.sangeng.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 产品分类：栏目，对应的实体类
 * 一个栏目对应多个产品，一个产品只有一个栏目，
 * 栏目-产品，一对多
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("data_category")
public class Category {
    private @TableId Long id;
    private String name;
    private String desc; // 对栏目的描述，管理员页面可见
    private Long createBy;
    private Date created;
    private Long updateBy;
    private Date updated;
    private Integer status; // 栏目状态：0正常，1停用
    private String path;
}
