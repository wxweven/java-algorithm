package com.wxweven.algorithm.number;

class 大整数相加 {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            ans.append(result >= 10 ? result - 10 : result);
            carry = result >= 10 ? 1 : 0;
            i--;
            j--;
        }

        // 最前面，如果有进位，需要加1
        if (carry == 1) {
            ans.append(1);
        }

        // 计算完以后的答案需要翻转过来
        return ans.reverse().toString();
    }
}