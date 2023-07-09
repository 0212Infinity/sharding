package com.example.jdbccluster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jdbccluster.entity.Order;
import com.example.jdbccluster.entity.OrderVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yu
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 查询每个订单的订单号和总订单金额
     *
     * @return OrderVo列表
     */
    @Select({"SELECT o.order_no, SUM(i.price * i.count) AS amount",
            "FROM t_order o JOIN t_order_item i ON o.order_no = i.order_no",
            "GROUP BY o.order_no"})
    List<OrderVo> getOrderAmount();
}
