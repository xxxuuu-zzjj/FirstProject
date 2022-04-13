package com.xzj.leetcode.leetcode.editor.cn;//实现RandomizedSet 类：

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//Java：O(1) 时间插入、删除和获取随机元素
class InsertDeleteGetrandomO1{
    public static void main(String[] args) {
        RandomizedSet solution = new InsertDeleteGetrandomO1().new RandomizedSet();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {

        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap();
        Random random = new Random();

    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if (hashMap.containsKey(val)){
            return false;
        }
        else{
            list.add(val);
            hashMap.put(val,list.size()-1);
        }
        return true;
    }
    
    public boolean remove(int val) {
        if (hashMap.containsKey(val)){
            int index = hashMap.get(val);
            int last = list.get(list.size() - 1);
            list.set(index,last);
            hashMap.put(last,index);
            list.remove(list.size()-1);
            hashMap.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
