//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 327 👎 0


package leetcode.editor.cn;

//二叉树的层次遍历 II

import java.util.*;

public class P107BinaryTreeLevelOrderTraversalIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while(!queue.isEmpty()){
			List<Integer> list = new ArrayList<>();
			int n = queue.size();
			for(int i = 0;i < n;i++){
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			result.add(0,list);
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}