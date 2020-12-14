package com.wxweven.algorithm.number;

import org.junit.Test;

import java.util.Random;

/**
 * @author wxweven
 */
public class Rand5生成Rand7 {

    public int rand7() {
        int res;
        do {
            res = rand5() + 5 * (rand5() - 1);
        } while (res > 21);

        return res % 7 + 1;
    }

    public int rand5() {
        return new Random().nextInt(5) + 1;
    }


    @Test
    public void test() {
        System.out.println(rand7());
    }
}