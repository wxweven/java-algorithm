/**
 * @(#)JZ旋转数组的最小数字.java, 3月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.algorithm.array;

/**
 * @author wxweven
 */
public class JZ08旋转数组的最小数字 {

    /*
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     */

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (numbers[mid] > numbers[high]) {
                // 此处，mid 不可能是最小值，所以 low = mid + 1
                low = mid + 1;

            } else if (numbers[mid] < numbers[high]) {
                // 此处，mid 有可能是最小值，如果让 high = mid - 1
                // 那么有可能就找不到正确的元素了
                high = mid;
            } else {
                high--;
            }
        }

        return numbers[low];
    }
}