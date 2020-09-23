//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 505 👎 0


package leetcode.editor.cn;

//解码方法

public class P91DecodeWays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P91DecodeWays().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
    	int length = s.length();
		if(length == 0){
			return 0;
		}

		int[] dp = new int[length + 1];
		dp[length] = 1;

		if(s.charAt(length-1) == '0'){
			dp[length-1] = 0;
		}else{
			dp[length-1] = 1;
		}

		for(int i = length - 2; i >= 0;i--){
			if(s.charAt(i) == '0'){
				dp[i] = 0;
				continue;
			}
			if((s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0') <= 26){
				dp[i] = dp[i+1] + dp[i+2];
			}else{
				dp[i] = dp[i+1];
			}
		}

		return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}