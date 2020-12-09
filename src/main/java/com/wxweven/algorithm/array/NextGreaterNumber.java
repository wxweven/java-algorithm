package com.wxweven.algorithm.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wxweven
 * @date 2020/12/09
 */
public class NextGreaterNumber {

    @Test
    public void test() {
        int[] res = nextGreaterNum(new int[]{2, 1, 2, 4, 3});
        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] nextGreaterNum(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return res;
    }
}
