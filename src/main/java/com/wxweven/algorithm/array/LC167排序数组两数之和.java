package com.wxweven.algorithm.array;

/**
 * @author wxweven
 */
public class LC167排序数组两数之和 {

    /*
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] find(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        /*
         * 循环退出啊条件：left < right，分析下这里为什么是 <
         * 1. 首先，left > right 的情况，肯定是不行的，这种情况说明遍历已经越界了；
         * 2. 其次，看下 left = right 的情况，因为题目中说要找到两个下标，如果 left = right，
         *      这种情况下，sum = nums[left] + nums[right] 就不是两个数相加，不满足题目条件。
         *
         * 综上，循环退出条件为 left < right
         *
         */
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}