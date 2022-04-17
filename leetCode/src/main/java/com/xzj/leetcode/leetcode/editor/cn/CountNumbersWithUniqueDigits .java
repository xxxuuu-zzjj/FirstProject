package com.xzj.leetcode.leetcode.editor.cn;//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10ⁿ 。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：1
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 数学 动态规划 回溯 👍 211 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：统计各位数字都不同的数字个数
class CountNumbersWithUniqueDigits{
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        List<Integer> dpList = new ArrayList<>();
        dpList.add(1);
        dpList.add(10);
        dpList.add(91);
        if (n<3)
            return dpList.get(n);
        for (int i = 3; i <= 8 ; i++) {
            dpList.add(i,dp(i)+dpList.get(i-1));
        }
        return dpList.get(n);
    }

    public int dp(int wei){
        int sum = 81;
        int status = 8;
        while (wei-->2){
            sum = sum * status--;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
