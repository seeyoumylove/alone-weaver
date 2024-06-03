package com.weaver.sms.template;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.weaver.sms.model.SmsResponseResult;
import com.weaver.sms.properties.AliSmsProperties;
import com.aliyun.teaopenapi.models.Config;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
  * @author: stone
  * date: 2024/6/3
  * description: 阿里发送短信的模板
  */
public class AliSmsTemplate {


    //配置对象
    private AliSmsProperties properties;

    public AliSmsTemplate(){

    }

    //构造器注入配置对象
    public AliSmsTemplate(AliSmsProperties properties){
        this.properties = properties;
    }

    /**
     * 通过手机号发送短信验证码
     * @param phone
     * @param verifyCode
     * @return
     */
    public SmsResponseResult sendSmsCode(String phone, String verifyCode){
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(properties.getAccessKeyId())
                // 您的AccessKey Secret
                .setAccessKeySecret(properties.getAccessKeySecret());
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        SmsResponseResult smsResponseResult = new SmsResponseResult();
        try {
            com.aliyun.dysmsapi20170525.Client client =  new com.aliyun.dysmsapi20170525.Client(config);
            // 配置短信发送模板
            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            sendSmsRequest.setPhoneNumbers(phone);
            sendSmsRequest.setSignName(properties.getSignName());
            sendSmsRequest.setTemplateCode(properties.getTemplateCode());
            sendSmsRequest.setTemplateParam("{ \"code\":\""+verifyCode+"\"}");
            SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
            return smsResponseResult;
        } catch (Exception e) {
            smsResponseResult.setCode(500);
            e.printStackTrace();
            return smsResponseResult;
        }
    }

}
