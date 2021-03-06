package com.wxweven.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class 最长不重复子串 {
    @Test
    public void test() {
        int res1 = lengthOfLongestSubstring("abcabcbb");
        int res2 = lengthOfLongestSubstring("bbbbb");
        int res3 = lengthOfLongestSubstring("pwwkew");

        Assert.assertEquals(res1, 3);
        Assert.assertEquals(res2, 1);
        Assert.assertEquals(res3, 3);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        int max = 0;


        /*
         * right 代表正常的遍历顺序，left代表不重复子串的起点
         * 初始条件，left=0，不重复子串的起点就是 'abcabcbb' 中的 'a'
         * 每次遍历，将遍历到的字符加入set
         * 当right=3时，set中的元素为"abc"，这时候再要加入'a'时，发现有重复，就需要删除left指向的'a'，
         * 同时j就要往后移位，直到指向新的不重复的子串的起点；这里需要注意的是while循环，因为有可能子串是"abcb",重复的元素是'b'，
         * 这时候仅仅删除left指向的a是不够的，必须要让left指向c才可以
         *
         * a b c a b c b b
         * left=0
         * @param s
         * @return
         */
        // right 代表正常的遍历顺序，left代表不重复子串的起点
        for (int left = 0, right = 0; right < chars.length; right++) {
            char c = chars[right];

            // 当前重复字符为c
            while (charSet.contains(c)) {
                // 循环的目的是把重复字符和重复字符之前的字符都从set中删除
                charSet.remove(chars[left]);
                left++;
            }

            // 下面两步是每次循环都需要做的
            charSet.add(c);
            max = Math.max(max, charSet.size());

        }
        return max;
    }
}
