package com.weaver.mock.condition;

import com.weaver.common.constants.ConfigureConstant;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断mock配置是否生效
 *
 * @author collin
 * @date 2019-04-27
 */
public class MockCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        Boolean mockApi = environment.getProperty(ConfigureConstant.MOCK_API_CONDITION_PROPERTY, Boolean.class);
        Boolean mockMethod = environment.getProperty(ConfigureConstant.MOCK_METHOD_CONDITION_PROPERTY, Boolean.class);
        return (mockApi != null && mockApi) || (mockMethod != null && mockMethod);
    }

}