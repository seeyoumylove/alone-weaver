package com.weaver.common.util.httprequest;

import java.util.Map;

/**
 * @author: stone
 * date: 2024/5/4
 * description: 连接请求工具类
 */
public class SdkClient {


    /**
     * @throws
     * @Title:get
     * @Description:get请求
     * @param:@param url
     * @param:@param headMap
     * @param:@return
     * @param:@throws Exception
     * @return:String
     */
    public static String get(String url, Map<String, String> headMap) throws Exception {

        return HttpClientPoolUtil.get(url, headMap);
    }

    /**
     * @throws
     * @Title:post
     * @Description:post请求
     * @param:@param url
     * @param:@param data JSON序列化后的参数 JSON.toJSONString(xxx)
     * @param:@param headMap
     * @param:@return
     * @param:@throws Exception
     * @return:String
     */
    public static String post(String url, String data, Map<String, String> headMap) throws Exception {


        return HttpClientPoolUtil.post(url, data, headMap);
    }

    /**
     * @throws
     * @Title:put
     * @Description:put请求
     * @param:@param url
     * @param:@param data JSON序列化后的参数 JSON.toJSONString(xxx)
     * @param:@param headMap
     * @param:@return
     * @param:@throws Exception
     * @return:String
     */
    public static String put(String url, String data, Map<String, String> headMap) throws Exception {
        return HttpClientPoolUtil.put(url, data, headMap);
    }

    /**
     * @throws
     * @Title:delete
     * @Description:delete请求
     * @param:@param url
     * @param:@param data JSON序列化后的参数 JSON.toJSONString(xxx)
     * @param:@param headMap
     * @param:@return
     * @param:@throws Exception
     * @return:String
     */
    public static String delete(String url, String data, Map<String, String> headMap) throws Exception {
        return HttpClientPoolUtil.delete(url, headMap);
    }

}
