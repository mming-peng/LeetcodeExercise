//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 723 👎 0


package leetcode.editor.cn;

//单词拆分

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P139WordBreak {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P139WordBreak().new Solution();
        List<String> wordDict = new LinkedList<>();
        wordDict.add("a");
        wordDict.add("b");
        Boolean a = solution.wordBreak("abc", wordDict);
        System.out.println(a);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            int n = s.length();
            boolean[] check = new boolean[n + 1];
            check[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (check[j] && set.contains(s.substring(j, i))) {
                        check[i] = true;
                        break;
                    }
                }
            }
            return check[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}