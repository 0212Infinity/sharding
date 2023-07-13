package com.example.proxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Yu
 */
@TableName("t_user")
@Data
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String uname;
}
