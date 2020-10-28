//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。 
//
// 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：false
// 
//
// 示例 3： 
//
// 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
// Related Topics 哈希表 
// 👍 97 👎 0


package leetcode.editor.cn;

//独一无二的出现次数

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1207UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1207UniqueNumberOfOccurrences().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i : map.values()) {
                if (set.contains(i)) {
                    return false;
                } else {
                    set.add(i);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}