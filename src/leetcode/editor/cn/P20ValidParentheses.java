//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1812 👎 0


package leetcode.editor.cn;

//有效的括号

import java.util.HashMap;
import java.util.Stack;

public class P20ValidParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P20ValidParentheses().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private HashMap<Character,Character> hashMap;

	public Solution(){
		hashMap = new HashMap<Character,Character>();
		this.hashMap.put(')','(');
		this.hashMap.put(']','[');
		this.hashMap.put('}','{');
	}
    public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i < s.length();i++){
			char c = s.charAt(i);
			if(this.hashMap.containsKey(c)){
				char top = stack.empty() ? '#' : stack.pop();
				if(top != this.hashMap.get(c)){
					return false;
				}
			}else{
				stack.push(c);
			}
		}
		return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}