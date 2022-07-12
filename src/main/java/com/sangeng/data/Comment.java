package com.sangeng.data;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Slf4j
@Data
@TableName("data_comment")
public class Comment {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品id
     */
    private Long pid;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论用户id
     */
    private Long uid;
    // /**
    //  * 被评论用户id,如果没有目标人,则该字段为空。
    //  */
    // private Long toId;
    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 2022-04-08 21:13:36
    private Date dateTime;

    /**
     * 冗余数据
     */
    private String userName;
    private String avatar;

    @TableField(exist = false)
    private String productName;
}
