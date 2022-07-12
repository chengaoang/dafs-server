package com.sangeng.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 网站设置表对应的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("data_setting")
public class Setting {
    private @TableId Long id;
    private String title; // 网站名字
    private String description; // 网站描述
    private Integer visit; // 访问次数
}
