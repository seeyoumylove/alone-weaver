package com.weaver.sms.template;

import com.weaver.common.util.httprequest.SdkClient;
import com.weaver.sms.model.SmsResponseResult;
import com.weaver.sms.properties.BaoSmsProperties;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
  * @author: stone
  * date: 2024/6/3
  * description: 短信宝发送短信的模板
  */
public class BaoSmsTemplate {

    //配置对象
    private BaoSmsProperties properties;

    //构造器注入配置对象
    public BaoSmsTemplate(BaoSmsProperties properties){
        this.properties = properties;
    }

    /**
     * 通过短信宝发送短信
     * @param userPhone
     * @param verifyCode
     * @return
     */
    public SmsResponseResult sendSmsCode(String userPhone, String verifyCode) {
        SmsResponseResult smsResponseResult = new SmsResponseResult();
        // 注意测试时，也请带上公司简称或网站签名，发送正规内容短信。千万不要发送无意义的内容：例如 测一下、您好。否则可能会收不到
        String testContent = String.format(properties.getSmsTemplate(), verifyCode);
        String thisRequestUrl = properties.getRequestUrl();
        if (userPhone.startsWith("+86")) {
            userPhone = userPhone.replace("+86", "");
            thisRequestUrl = properties.getRequestUrl().replace("wsms","sms");
        }
        StringBuilder requestParam = new StringBuilder();
        requestParam.append("u=").append(properties.getPassword()).append("&");
        requestParam.append("p=").append(md5(properties.getPassword())).append("&");
        requestParam.append("m=").append(encodeUrlString(userPhone,"UTF-8")).append("&");
        requestParam.append("c=").append(encodeUrlString(testContent, "UTF-8"));
        thisRequestUrl = thisRequestUrl + "?" + requestParam;
        try {
            String result = SdkClient.get(thisRequestUrl, new HashMap<>());
            if ("0".equals(result)) {
                return smsResponseResult;
            } else {
                smsResponseResult.setCode(500);
                return smsResponseResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            smsResponseResult.setCode(500);
            return smsResponseResult;
        }
    }

    public static String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");

                }
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null) {
            return str;
        }
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }


}
