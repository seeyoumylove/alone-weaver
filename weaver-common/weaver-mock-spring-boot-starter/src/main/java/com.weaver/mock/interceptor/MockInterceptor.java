package com.weaver.mock.interceptor;

import com.weaver.common.constants.SymbolConstant;
import com.weaver.mock.properties.MockProperties;
import com.weaver.mock.util.MockUtil;
import lombok.RequiredArgsConstructor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

/**
  * @author: stone
  * date: 2024/6/3
  * description: mock切面拦截器
  */
@RequiredArgsConstructor
public class MockInterceptor implements MethodInterceptor {

    private final MockProperties mockProperties;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 白名单的直接跳过
        Method m = invocation.getMethod();
        Set<String> whitelist = mockProperties.getWhilelist();
        if (whitelist != null) {
            String code = m.getDeclaringClass().getName() + SymbolConstant.DOT + m.getName();
            if (whitelist.contains(code)) {
                return invocation.proceed();
            }
        }

        // 非白名单的返回mock
        Type returnType = m.getGenericReturnType();
        // 泛型
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            return MockUtil.mock(m.getReturnType(), actualTypeArguments);
        } else {
            return MockUtil.mock(m.getReturnType());
        }
    }

}