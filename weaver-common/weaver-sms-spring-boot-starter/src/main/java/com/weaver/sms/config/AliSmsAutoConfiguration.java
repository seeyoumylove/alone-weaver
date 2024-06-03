package com.weaver.sms.config;

import com.weaver.sms.properties.AliSmsProperties;
import com.weaver.sms.properties.BaoSmsProperties;
import com.weaver.sms.template.AliSmsTemplate;
import com.weaver.sms.template.BaoSmsTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
  * @author: stone
  * date: 2024/6/3
  * description: 开启sms短信配置功能 为注册spring-boot-starter作准备
  */
@EnableConfigurationProperties({AliSmsProperties.class, BaoSmsProperties.class})
@Configuration
public class AliSmsAutoConfiguration {

    /**
     * 自动注入 AliSMSProperties对象
     * @param properties
     * @return
     */
    @Bean
    public AliSmsTemplate aliSmsTemplate(AliSmsProperties properties){
        //创建AliSMSTemplate，注册到Spring容器中
        return new AliSmsTemplate(properties);
    }

    /**
     * 自动注入 AliSMSProperties对象
     * @param properties
     * @return
     */
    @Bean
    public BaoSmsTemplate baoSmsTemplate(BaoSmsProperties properties){
        //创建AliSMSTemplate，注册到Spring容器中
        return new BaoSmsTemplate(properties);
    }
}
