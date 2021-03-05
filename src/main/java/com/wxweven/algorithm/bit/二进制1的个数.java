package com.wxweven.algorithm.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 */
public class 二进制1的个数 {

    /*
     * 这种解法严格来说并不对，因为数字的二进制表示中，数值都是以补码的形式保存。
     * 正数的补码和原码一样，
     * 负数的补码，就是在原来的原码基础上，保持符号位不变，其他位取反，然后再加1
     * 与求绝对值不一样
     */
    private int numOfOne(int num) {
        int n = Math.abs(num);

        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }

            n >>= 1;
        }

        return count;
    }

    public int numOfOneV2(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }

            flag <<= 1;
        }

        return count;
    }

    /*
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。
     * 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
     */
    public int numOfOneV3(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }

        return count;
    }

    @Test
    public void test() {
        int count = numOfOneV2(-4);
        int count2 = numOfOneV2(4);

        int count31 = numOfOneV2(-4);
        int count32 = numOfOneV2(4);
        System.out.println(count31);
        System.out.println(count32);
        Assert.assertEquals(30, count31);
        Assert.assertEquals(1, count32);
    }
}

/*
 * -4 的二进制：符号位不变，其他位取反 + 1
 * 1000 0000 0000 0000 0000 0000 0000 0100
 * 1111 1111 1111 1111 1111 1111 1111
 * +1
 *
 * 最终：
 * 1111 1111 1111 1111 1111 1111 1111 1100
 * 一共有30个1
 *
 * 4 的二进制：
 * 0000 0000 0000 0000 0000 0000 0000 0100
 * 一共有1个1
 */