package com.weaver.mock.strategy;

import java.lang.annotation.Annotation;
import java.util.List;


import com.weaver.common.util.RandomUtil;

/**
 * 手机号码mock生成策略
 *
 * @author collin
 * @date 2019-04-17
 */
public class MobileAttributeStrategy  {

	public String getValue(Class<?> attrType, List<Annotation> attrAnnotations) {
		return "1" + RandomUtil.generateRangeRandom(3, 8) + RandomUtil.generateRandom(true, 9);
	}

}