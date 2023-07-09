package com.example.jdbccluster;

import com.example.jdbccluster.entity.Order;
import com.example.jdbccluster.entity.OrderItem;
import com.example.jdbccluster.entity.OrderVo;
import com.example.jdbccluster.mapper.OrderItemMapper;
import com.example.jdbccluster.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * 绑定表：指分片规则一致的一组分片表。
 * 使用绑定表进行多表关联查询时，必须使用分片键进行关联，否则会出现笛卡尔积关联或跨库关联，从而影响查询效率。
 */
@SpringBootTest
public class BindingTableTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 测试关联表的插入
     */
    @Test
    public void testInsertOrderAndOrderItem() {
        for (long i = 1; i < 5; i++) {
            Order order = new Order();
            order.setOrderNo("DINGDANHAO" + i);
            order.setUserId(1L);
            orderMapper.insert(order);

            for (int j = 0; j < 3; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("DINGDANHAO" + i);
                orderItem.setUserId(1L);
                orderItem.setPrice(new BigDecimal(10));
                orderItem.setCount(2);
                orderItemMapper.insert(orderItem);
            }
        }

        for (long i = 5; i < 9; i++) {
            Order order = new Order();
            order.setOrderNo("DINGDANHAO" + i);
            order.setUserId(2L);
            orderMapper.insert(order);

            for (int j = 0; j < 3; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("DINGDANHAO" + i);
                orderItem.setUserId(2L);
                orderItem.setPrice(new BigDecimal(3));
                orderItem.setCount(3);
                orderItemMapper.insert(orderItem);
            }
        }
    }

    /**
     * 测试关联表查询
     */
    @Test
    public void testGetOrderAmount() {
        List<OrderVo> orderAmountList = orderMapper.getOrderAmount();
        orderAmountList.forEach(System.out::println);
    }
}
