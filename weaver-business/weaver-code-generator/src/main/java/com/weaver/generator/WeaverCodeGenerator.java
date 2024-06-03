package com.weaver.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
  * @author: stone
  * date: 2024/6/3
  * description: 自动生成代码启动类
  */
@SpringBootApplication(scanBasePackages = "com.weaver.generator")
public class WeaverCodeGenerator {
    public static void main(String[] args) {
        SpringApplication.run(WeaverCodeGenerator.class, args);
    }
}
