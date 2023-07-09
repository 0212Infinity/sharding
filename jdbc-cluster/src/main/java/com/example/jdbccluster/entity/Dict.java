package com.example.jdbccluster.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yu
 */
@TableName("t_dict")
@Data
public class Dict {
    /**
     * 可以使用MyBatisPlus的雪花算法
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String dictType;
}
