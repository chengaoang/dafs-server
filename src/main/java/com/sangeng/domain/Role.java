package com.sangeng.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1;

    private @TableId Long id; // 主键
    private String name; // 角色名字
}
