package com.example.jdbccluster.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Yu
 */
@Data
public class OrderVo {
    private String orderNo;
    private BigDecimal amount;
}
