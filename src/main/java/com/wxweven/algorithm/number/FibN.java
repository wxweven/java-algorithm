/**
 * @(#)FibN.java, 3月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.algorithm.number;

/**
 * @author wxweven
 */
public class FibN {

    public long fibN(int n) {
        if (n < 0) {
            return -1;
        }

        if (n < 2) {
            return n;
        }

        int one = 0;
        int two = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = one + two;
            one = two;
            two = result;
        }

        return result;
    }
}