package com.wxweven.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

public class 数字在排序数组中出现的次数 {
    public static int getTimes(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = arr.length;

        int first = getFirstIndex(arr, num, 0, len - 1);
        int last = getLastIndex(arr, num, 0, len - 1);

        if (first == -1 || last == -1) {
            return 0;
        }

        return last - first + 1;
    }

    public static int getFirstIndex(int[] arr, int num, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) >> 1;

        if (arr[middle] == num) {
            if (middle == 0 || arr[middle - 1] < num) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (arr[middle] < num) {
            start = middle + 1;

        } else {
            end = middle - 1;
        }

        return getFirstIndex(arr, num, start, end);

    }

    public static int getFirstIndex2(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (arr[mid] == target) {
                // 收敛右边
                right = mid - 1;

            } else if (arr[mid] < target) {
                // 正常的二分搜索，往右侧找
                left = mid + 1;
            } else if (arr[mid] > target) {
                // 正常的二分搜索，往右侧找
                right = mid - 1;
            }
        }

        // 检查left越界
        if (left >= arr.length || arr[left] != target) {
            return -1;
        }

        return left;
    }

    public static int getLastIndex(int[] arr, int num, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) >> 1;

        if (arr[middle] == num) {
            if (middle == end || arr[middle + 1] > num) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (arr[middle] < num) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }

        return getLastIndex(arr, num, start, end);
    }

    public static int getLastIndex2(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (arr[mid] == target) {
                // 收敛左边
                left = mid + 1;

            } else if (arr[mid] < target) {
                // 正常的二分搜索，往右侧找
                left = mid + 1;
            } else if (arr[mid] > target) {
                // 正常的二分搜索，往右侧找
                right = mid - 1;
            }
        }

        // 检查left越界
        if (right < 0 || arr[right] != target) {
            return -1;
        }

        return right;
    }

    @Test
    public void test() {
        int[] arrs = new int[]{5, 7, 7, 8, 8, 10};
        int times = getTimes(arrs, 8);
        System.out.println(times);
        Assert.assertEquals(2, times);

        times = getTimes(arrs, 4);
        System.out.println(times);
        Assert.assertEquals(0, times);
    }
}
