package com.weaver.sms.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
  * @author: stone
  * date: 2024/6/3
  * description: 阿里云短信配置
  */
@Data
//绑定配置
@ConfigurationProperties(prefix = "bao.sms")
public class BaoSmsProperties {

    /**
     * 短信宝用户名
     */
    String username;

    /**
     * 短信宝密码
     */
    String password;

    /**
     * 短信宝发送模板
     */
    String smsTemplate;

    /**
     * 短信宝请求url
     */
    String requestUrl;
}
