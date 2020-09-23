//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 980 👎 0


package leetcode.editor.cn;

//最长上升子序列

public class P300LongestIncreasingSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P300LongestIncreasingSubsequence().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
		int length = nums.length;
		if(length < 2){
			return length;
		}

		int[] ans = new int[length];
		ans[0] = nums[0];
		int end = 0;

		for(int i = 1;i < length;i++){
			if(nums[i] > ans[end]){
				end++;
				ans[end] = nums[i];
			}else{
				int left = 0;
				int right = end;
				while(left < right){
					int mid = left + ((right - left) >>> 2);
					if(ans[end] < mid){
						right = mid;
					}else{
						left = mid + 1;
					}
				}

				ans[left] = nums[i];
			}
		}
		end++;
		return end;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}