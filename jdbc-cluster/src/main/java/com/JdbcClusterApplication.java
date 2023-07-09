package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yu
 */
@SpringBootApplication
@MapperScan("com.example.jdbccluster.mapper")
public class JdbcClusterApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdbcClusterApplication.class, args);
    }
}
