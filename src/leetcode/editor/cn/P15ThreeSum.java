//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2528 👎 0


package leetcode.editor.cn;

//三数之和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15ThreeSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P15ThreeSum().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();

		Arrays.sort(nums);

		int len = nums.length;

		for(int i = 0;i < nums.length;i++){
			if(nums[i] > 0){
				return lists;
			}

			if(i > 0 && nums[i] == nums[i-1]){
				continue;
			}

			int curr = nums[i];
			int L = i + 1,R = len - 1;
			while(L < R){
				int sum = curr + nums[L] + nums[R];
				if(sum == 0){
					List<Integer> list = new ArrayList<>(3);
					list.add(curr);
					list.add(nums[L]);
					list.add(nums[R]);
					lists.add(list);
					while(L < R && nums[L+1] == nums[L]){
						++L;
					}
					while(L < R && nums[R] == nums[R-1]){
						--R;
					}
					++L;
					--R;
				}else if(sum > 0){
					--R;
				}else {
					++L;
				}
			}
		}
		return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}