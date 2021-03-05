/**
 * @(#)M2N改变的位数.java, 3月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.algorithm.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 */
public class M2N改变的位数 {

    /*
     * 输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n。
     * 比如10的二进制表示为1010，13的二进制表示为1101，需要改变1010中的3位才能得到1101。
     * 我们可以分为两步解决这个问题：第一步求这两个数的异或，第二步统计异或结果中1的位数。
     *
     */

    public int m2n(int m, int n) {
        int res = m ^ n;

        int count = 0;

        while (res != 0) {
            count++;
            res = res & (res - 1);
        }

        return count;
    }

    @Test
    public void test() {
        int m = 10;
        int n = 13;

        int count = m2n(10, 13);
        System.out.println(count);
        Assert.assertEquals(3, count);
    }
}