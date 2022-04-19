package com.xzj.leetcode.leetcode.editor.cn;
//给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。 
//
// 
//
// 示例 1: 
//
// 
//输入：n = 2
//输出：987
//解释：99 x 91 = 9009, 9009 % 1337 = 987
// 
//
// 示例 2: 
//
// 
//输入： n = 1
//输出： 9
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 数学 👍 70 👎 0

import java.math.BigInteger;

/**
 * 最大回文数乘积
 *
 * @author saint
 */
class P479_LargestPalindromeProduct {
    public static void main(String[] args) {
        Solution solution = new P479_LargestPalindromeProduct().new Solution();
        solution.largestPalindrome(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPalindrome(int n) {
            if (n == 1) return 9;
            int max = (int) Math.pow(10, n) - 1;
            for (int i = max; i >= 0; i--) {
                long num = i, t = i;
                while (t != 0) {
                    num = num * 10 + (t % 10);
                    t /= 10;
                }
                for (long j = max; j * j >= num; j--) {
                    if (num % j == 0) return (int) (num % 1337);
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
