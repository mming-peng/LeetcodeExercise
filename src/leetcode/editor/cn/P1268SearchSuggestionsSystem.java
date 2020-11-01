//给你一个产品数组 products 和一个字符串 searchWord ，products 数组中每个产品都是一个字符串。 
//
// 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品
//。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。 
//
// 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。 
//
// 
//
// 示例 1： 
//
// 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord 
//= "mouse"
//输出：[
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
//输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
//输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
// 
//
// 示例 2： 
//
// 输入：products = ["havana"], searchWord = "havana"
//输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// 
//
// 示例 3： 
//
// 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
//
//输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"]
//,["bags"]]
// 
//
// 示例 4： 
//
// 输入：products = ["havana"], searchWord = "tatiana"
//输出：[[],[],[],[],[],[],[]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= products.length <= 1000 
// 1 <= Σ products[i].length <= 2 * 10^4 
// products[i] 中所有的字符都是小写英文字母。 
// 1 <= searchWord.length <= 1000 
// searchWord 中所有字符都是小写英文字母。 
// 
// Related Topics 字符串 
// 👍 56 👎 0


package leetcode.editor.cn;

//搜索推荐系统

import java.util.ArrayList;
import java.util.List;

public class P1268SearchSuggestionsSystem {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1268SearchSuggestionsSystem().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Node { // 字典树节点
            Node[] children = new Node[26]; // 该节点后续连接的字符
            String fullString; // 如果该节点为字符串结尾，保存该字符串
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Node root = new Node(); // 字典树根节点
            for (String p : products) { // 循环每个单词创建字典树
                Node r = root; // 当前根节点
                // 循环当前单词每个字符，存入字典树
                for (int i = 0; i < p.length(); i++) {
                    // 当前字符的index
                    int index = p.charAt(i) - 'a';
                    // 如果当前字符不在当前节点的子节点中
                    if (r.children[index] == null) {
                        // 添加当前字符到子节点
                        r.children[index] = new Node();
                    }
                    // 更新当前根节点
                    r = r.children[index];
                }
                // 当前字符串所有字符插入完成之后，
                // 将当前节点设置为当前单词结束节点。
                r.fullString = p;
            }
            // 返回结果
            List<List<String>> res = new ArrayList<>();
            // 循环searchWord的每个字符
            for (int i = 0; i < searchWord.length(); i++) {
                // 如果当前根节点为空，说明不存在以当前字符开头的单词
                if (root == null) {
                    res.add(new ArrayList<>());
                    continue;
                }
                // 将根节点更新至当前searchWord的字符所在节点
                root = root.children[searchWord.charAt(i) - 'a'];
                // 取得该节点下存在的单词
                res.add(getList(root, new ArrayList<>()));
            }
            return res;
        }

        List<String> getList(Node root, List<String> list) {
            // 如果根节点为空或者已经找到3条数据，返回list
            if (root == null || list.size() == 3) {
                return list;
            }
            // 如果当前节点为单词结尾，将该单词加入返回结果
            if (root.fullString != null) {
                list.add(root.fullString);
            }
            // 循环当前节点下所有分支
            for (int i = 0; i < 26; i++) {
                // 如果当前分支存在字符
                if (root.children[i] != null) {
                    // 递归查找当前分支下完整单词
                    getList(root.children[i], list);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}