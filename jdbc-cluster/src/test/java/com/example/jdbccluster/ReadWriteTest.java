package com.example.jdbccluster;

import com.example.jdbccluster.entity.User;
import com.example.jdbccluster.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@SpringBootTest
public class ReadWriteTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 读写分离：写入数据的测试
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setUname("zhang san");
        userMapper.insert(user);
    }

    /**
     * 读写分离：事务测试
     */
    @Transactional
    @Test
    public void testTrans(){
        // 注意：在JUnit环境下的@Transactional注解，默认情况下就会对事务进行回滚（即使在没加注解@Rollback，也会对事务回滚）
        User user = new User();
        user.setUname("li si");
        userMapper.insert(user);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 读写分离：负载均衡测试
     */
    @Test
    public void testSelectAll(){
        List<User> users1 = userMapper.selectList(null);
        List<User> users2 = userMapper.selectList(null);
        List<User> users3 = userMapper.selectList(null);
        List<User> users4 = userMapper.selectList(null);
        // users1.forEach(System.out::println);
    }
}
