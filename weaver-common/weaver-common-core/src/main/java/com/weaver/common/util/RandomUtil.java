package com.weaver.common.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机工具类
 *
 * @author collin
 * @date 2019-04-08
 */
public class RandomUtil  {

    /**
     * 随机字符表
     */
    protected static String randomStrTable = null;
    /**
     * 随机数字表
     */
    protected static String randomPureNumberTable = null;


    private RandomUtil() {
    }

    /**
     * 创建指定数量的随机字符串
     *
     * @param pureNumber 是否是纯数字
     * @param length     随机串长度
     * @return
     */
    public static String generateRandom(boolean pureNumber, int length) {
        return generateRandom(ThreadLocalRandom.current(), pureNumber, length);
    }

    /**
     * 生成uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成指定范围随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int generateRangeRandom(int min, int max) {
        return generateRangeRandom(ThreadLocalRandom.current(), min, max);
    }

    /**
     * 生成指定范围随机数
     *
     * @param random
     * @param min
     * @param max
     * @return
     */
    protected static int generateRangeRandom(Random random, int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 创建指定数量的随机字符串
     *
     * @param random
     * @param pureNumber 是否是纯数字
     * @param length     随机串长度
     * @return
     */
    protected static String generateRandom(Random random, boolean pureNumber, int length) {
        StringBuilder result = new StringBuilder(length);
        String strTable = pureNumber ? randomPureNumberTable : randomStrTable;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(strTable.length());
            result.append(strTable.charAt(index));
        }

        return result.toString();
    }

    /**
     * 随机排序
     *
     * @param array
     * @return
     */
    public static <E> E[] randomSort(E[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        for (int i = 0, len = array.length; i < len; i++) {
            int currentRandom = ThreadLocalRandom.current().nextInt(len);
            E current = array[i];
            array[i] = array[currentRandom];
            array[currentRandom] = current;
        }

        return array;
    }

    /**
     * 随机排序
     *
     * @param list
     * @return
     */
    public static <E> List<E> randomSort(List<E> list) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }

        for (int i = 0, len = list.size(); i < len; i++) {
            int currentRandom = ThreadLocalRandom.current().nextInt(len);
            E current = list.get(i);
            list.set(i, list.get(currentRandom));
            list.set(currentRandom, current);
        }

        return list;
    }

}