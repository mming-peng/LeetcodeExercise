//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 426 👎 0


package leetcode.editor.cn;

//二叉树的前序遍历

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P144BinaryTreePreorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	if(root == null){
    		return list;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
    	TreeNode node = root;
    	while(!stack.isEmpty() || node != null){
    		while (node != null){
    			list.add(node.val);
    			stack.push(node);
    			node = node.left;
			}
    		node = stack.pop();
    		node = node.right;
		}
    	return list;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}