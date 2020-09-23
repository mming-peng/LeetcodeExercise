//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 315 👎 0


package leetcode.editor.cn;

//最长重复子数组

public class P718MaximumLengthOfRepeatedSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int[][] dp = new int[m+1][n+1];
		int ans = 0;
		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){
				if(A[i] == B[j]){
					dp[i+1][j+1] = dp[i][j] + 1;
					ans = Math.max(ans,dp[i+1][j+1]);
				}else{
					dp[i+1][j+1] = 0;
				}
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}