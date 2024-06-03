package com.weaver.mock.strategy;

import com.weaver.common.util.RandomUtil;

import java.lang.annotation.Annotation;
import java.util.List;



/**
 * 金额mock生成策略
 *
 * @author collin
 * @date 2019-04-17
 */
public class MoneyAttributeStrategy  {

	public Long getValue(Class<?> attrType, List<Annotation> attrAnnotations) {
		return (long) RandomUtil.generateRangeRandom(100, 1000000);
	}

}