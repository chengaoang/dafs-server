package com.sangeng.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 用户表对应的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    @TableId(type = IdType.AUTO)
    private Long id;// 主键
    private String userName;// 用户名
    private String nickName;// 昵称
    private String password;// 密码
    private String status;// 账号状态（0正常 1停用）
    private String email;// 邮箱
    private String phonenumber; // 手机号
    private String sex;// 用户性别（0男，1女，2未知）
    private String avatar;// 头像
    private String userType;// 用户类型（0管理员，1普通用户）
    private Long createBy;// 创建人的用户id
    private Date createTime;// 创建时间
    private Long updateBy;// 更新人
    private Date updateTime;// 更新时间
    private Integer delFlag;// 删除标志（0代表未删除，1代表已删除）
}