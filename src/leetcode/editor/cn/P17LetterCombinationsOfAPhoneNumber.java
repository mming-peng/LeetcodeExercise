//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 966 👎 0


package leetcode.editor.cn;

//电话号码的字母组合

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17LetterCombinationsOfAPhoneNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
	 	 solution.letterCombinations("23");
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> list = new ArrayList<>();
    	if(digits.length() == 0){
    		return list;
		}

		Map<Character,String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		backtack(list,map,digits,0,new StringBuffer());

		return list;

    }

	private void backtack(List<String> list, Map<Character, String> map, String digits, int index, StringBuffer stringBuffer) {
    	if(index == digits.length()){
    		list.add(stringBuffer.toString());
		}else {
    		char digit = digits.charAt(index);
    		String s = map.get(digit);
    		for(int i = 0;i < s.length();i++){
				stringBuffer.append(s.charAt(i));
				backtack(list,map,digits,index+1,stringBuffer);
				stringBuffer.deleteCharAt(index);
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}