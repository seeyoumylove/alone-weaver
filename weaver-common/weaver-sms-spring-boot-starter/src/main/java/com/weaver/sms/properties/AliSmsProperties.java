package com.weaver.sms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
  * @author: stone
  * date: 2024/6/3
  * description: 阿里云短信配置
  */
@Data
//绑定配置
@ConfigurationProperties(prefix = "alicloud.sms")
public class AliSmsProperties {

    //key ID
    private String accessKeyId;

    //秘钥
    private String accessKeySecret;

    //地区
    private String region;

    //签名
    private String signName;

    //模板编号
    private String templateCode;
}
