package com.example.proxy.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Yu
 */
@Data
public class OrderVo implements Serializable {
    private String orderNo;
    private BigDecimal amount;
}
