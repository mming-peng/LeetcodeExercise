//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 963 👎 0


package leetcode.editor.cn;

//全排列

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P46Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46Permutations().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> out = new ArrayList<>();
            for (int i : nums) {
                out.add(i);
            }
            int n = nums.length;
            backtrack(res, out, n, 0);
            return res;
        }

        private void backtrack(List<List<Integer>> res, List<Integer> out, int n, int fi) {
            if (fi == n) {
                res.add(new ArrayList<>(out));
            }
            for (int i = fi; i < n; i++) {
                Collections.swap(out, fi, i);
                backtrack(res, out, n, fi + 1);
                Collections.swap(out, i, fi);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}