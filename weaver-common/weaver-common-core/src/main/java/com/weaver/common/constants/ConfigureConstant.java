package com.weaver.common.constants;

/**
 * @author: stone
 * date: 2024/6/3
 * description: 公共常量定义
 */
public interface ConfigureConstant {


    /**
     * 公共配置属性前缀
     */
    public static final String SMART_PROPERTIES_PREFIX = "smart";
    /**
     * rpc 日志打印开关配置name
     */
    public static final String FEIGN_LOG_CONDITION_PROPERTY = SMART_PROPERTIES_PREFIX + ".feign.log.enable";
    /**
     * api 日志打印开关配置name
     */
    public static final String API_LOG_CONDITION_PROPERTY = SMART_PROPERTIES_PREFIX + ".apiLog.enable";
    /**
     * api mock开关配置name
     */
    public static final String MOCK_API_CONDITION_PROPERTY = SMART_PROPERTIES_PREFIX + ".mock.api";
    /**
     * method mock开关配置name
     */
    public static final String MOCK_METHOD_CONDITION_PROPERTY = SMART_PROPERTIES_PREFIX + ".mock.method";
    /**
     * method log开关配置name
     */
    public static final String METHOD_LOG_CONDITION_PROPERTY = SMART_PROPERTIES_PREFIX + ".methodLog.enable";
    /**
     * mybatis log开关配置name
     */
    public static final String MYBATIS_LOG_CONDITION_PROPERTY = SMART_PROPERTIES_PREFIX + ".mybatis.log.enable";

}