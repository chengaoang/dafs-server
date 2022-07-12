package com.sangeng.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单表Menu对应的实体类
 */
@TableName(value="sys_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {
    private static final long serialVersionUID = -54979041104113736L;
    
    @TableId
    private Long id;
    private String menuName;// 菜单名: category
    private String path;// 路由地址: /category
    private String component;// 组件路径: /category
    private String visible;// 菜单状态（0显示 1隐藏）: 0
    private String status; // 菜单状态（0正常 1停用）: 0
    private String perms;// 权限标识: sys:category:delete
    private String icon;// 菜单图标:
    private Long createBy;
    private Date createTime;
    private Long updateBy;
    private Date updateTime;
    private Integer delFlag;// 是否删除（0未删除 1已删除）: 0
    private String remark;// 备注: 这是菜单栏目
}