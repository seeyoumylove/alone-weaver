/*
 * Copyright © 2019 collin (1634753825@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weaver.mock.autoconfigure;


import com.weaver.common.util.aop.AspectInterceptorUtil;
import com.weaver.common.util.aop.PackageConfig;
import com.weaver.mock.annotation.Mock;
import com.weaver.mock.condition.MockCondition;
import com.weaver.mock.interceptor.MockInterceptor;
import com.weaver.mock.properties.MockProperties;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * mock切面配置
 *
 * @author collin
 * @date 2021-11-13
 */
@Configuration
@EnableConfigurationProperties({MockProperties.class})
@Conditional(MockCondition.class)
public class MockAspectAutoConfiguration {

    @Bean
    public MockInterceptor mockInterceptor(final MockProperties smartProperties) {
        return new MockInterceptor(smartProperties);
    }

    @Bean
    public Advisor mockAdvisor(final MockInterceptor mockInterceptor, final MockProperties mockProperties) {
        List<Class<? extends Annotation>> annotations = new ArrayList<>(8);
        if (mockProperties.isApi()) {
            annotations.addAll(AspectInterceptorUtil.getApiAnnotations());
        }
        if (mockProperties.isMethod()) {
            annotations.add(Mock.class);
        }

        if (annotations.isEmpty()) {
            throw new UnsupportedOperationException("api and method mock cannot be false at the same time!");
        }

        AspectJExpressionPointcut mockPointcut = new AspectJExpressionPointcut();
        String mockExpression = AspectInterceptorUtil.buildExpression(PackageConfig.getBasePackages(), AspectInterceptorUtil.getMethodExpression(annotations));
        mockPointcut.setExpression(mockExpression);

        DefaultBeanFactoryPointcutAdvisor mockAdvisor = new DefaultBeanFactoryPointcutAdvisor();
        mockAdvisor.setAdvice(mockInterceptor);
        mockAdvisor.setPointcut(mockPointcut);

        return mockAdvisor;
    }

}