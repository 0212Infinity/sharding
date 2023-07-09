package com.example.jdbccluster;

import com.example.jdbccluster.entity.Dict;
import com.example.jdbccluster.mapper.DictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BroadcastTableTest {

    @Autowired
    private DictMapper dictMapper;

    /**
     * 广播表：插入测试
     */
    @Test
    public void testInsertBroadcast() {
        Dict dict = new Dict();
        dict.setDictType("type1");
        dictMapper.insert(dict);
    }

    /**
     * 查询操作
     * 随机负载均衡规则
     */
    @Test
    public void testSelectBroadcast() {
        List<Dict> dictList = dictMapper.selectList(null);
        dictMapper.selectList(null);
        dictMapper.selectList(null);
        dictMapper.selectList(null);
        dictMapper.selectList(null);
        dictMapper.selectList(null);
        dictList.forEach(System.out::println);
    }
}
