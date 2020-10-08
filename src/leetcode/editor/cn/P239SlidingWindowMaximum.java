//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 583 👎 0


package leetcode.editor.cn;

//滑动窗口最大值

public class P239SlidingWindowMaximum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P239SlidingWindowMaximum().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] left = new int[n];
		left[0] = nums[0];
		int[] right = new int[n];
		right[n-1] = nums[n-1];

		for(int i = 1;i < n;i++){
			if(i % k == 0){
				left[i] = nums[i];
			}else{
				left[i] = Math.max(left[i-1],nums[i]);
			}

			int j = n - i - 1;
			if((j + 1) % k == 0){
				right[j] = nums[j];
			}else{
				right[j] = Math.max(right[j+1],nums[j]);
			}
		}

		int[] output = new int[n-k+1];
		for(int i = 0;i < n-k+1;i++){
			output[i] = Math.max(left[i+k-1],right[i]);
		}
		return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}