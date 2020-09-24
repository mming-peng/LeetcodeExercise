//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 65 👎 0


package leetcode.editor.cn;

//扑克牌中的顺子

import java.util.HashSet;
import java.util.Set;

public class P61BuKePaiZhongDeShunZiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P61BuKePaiZhongDeShunZiLcof().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
		Set<Integer> set = new HashSet<>();

		int min = 14,max = 0;

		for (int num : nums) {
		    if(num == 0){
		    	continue;
			}

		    min = Math.min(min,num);
		    max = Math.max(max,num);

		    if(set.contains(num)){
		    	return false;
			}

		    set.add(num);
		}

		return max - min < 5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}