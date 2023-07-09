package com.example.jdbccluster;

import com.example.jdbccluster.entity.Order;
import com.example.jdbccluster.entity.User;
import com.example.jdbccluster.mapper.OrderMapper;
import com.example.jdbccluster.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class VerticalShardingTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 垂直分片：插入数据测试
     */
    @Test
    public void testInsertOrderAndUser() {
        User user = new User();
        user.setUname("张三");
        userMapper.insert(user);

        Order order = new Order();
        order.setOrderNo("DINGDANHAO00001");
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
    }

    /**
     * 垂直分片：查询数据测试
     */
    @Test
    public void testSelectFromOrderAndUser() {
        User user = userMapper.selectById(1L);
        Order order = orderMapper.selectById(1L);
    }
}
