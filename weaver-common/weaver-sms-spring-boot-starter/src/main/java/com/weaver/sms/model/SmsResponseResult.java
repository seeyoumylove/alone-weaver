package com.weaver.sms.model;

import lombok.Data;

/**
 * @author: stone
 * Date:  2024/6/3 13:46
 * Description:
 */
@Data
public class SmsResponseResult {

    /**
     * 返回结果 0成功 其他失败
     */
    private Integer code = 0;

    /**
     * 返回的msg
     */
    private String msg;

}
