//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1003 👎 0


package leetcode.editor.cn;

//对称二叉树

public class P101SymmetricTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P101SymmetricTree().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
		return check(root,root);
    }

    public boolean check(TreeNode p,TreeNode q){
    	if(p == null && q == null){
    		return true;
		}

    	if(p == null || q == null){
    		return false;
		}

    	return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}