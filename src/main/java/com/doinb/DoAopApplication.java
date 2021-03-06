package com.doinb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * springboot 排除数据源启动， 搭建简易工程用于学习
 * <p>
 * 1. 启动AOP代理方式 @EnableAspectJAutoProxy
 * 2. 同时需要配置切面类 com.doinb.spring.aop.DoAspect
 * 3. pom.xml配置
 * <dependency>
 * <groupId>com.walterjwhite.java.dependencies</groupId>
 * <artifactId>aspectjrt</artifactId>
 * <version>0.0.17</version>
 * </dependency>
 * <dependency>
 * <groupId>org.aspectj</groupId>
 * <artifactId>aspectjweaver</artifactId>
 * <version>1.8.3</version>
 * </dependency>
 */
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class DoAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoAopApplication.class, args);
    }
}