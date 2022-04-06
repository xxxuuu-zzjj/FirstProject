package com.xzj.leetcode.leetcode.editor.cn;
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 730 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author saint
 */
class P118_PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new P118_PascalsTriangle().new Solution();
        solution.generate(5);
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows>0){
            List<Integer> first = new ArrayList<>();
            first.add(1);
            ret.add(first);
            if (numRows>1){
                List<Integer> second = new ArrayList<>();
                second.add(1);
                second.add(1);
                ret.add(second);
            }
        }
        else return ret;
        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0||j==i){
                    list.add(j,1);
                }
                else
                    list.add(j,ret.get(i-1).get(j)+ret.get(i-1).get(j-1));
            }
            ret.add(list);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
