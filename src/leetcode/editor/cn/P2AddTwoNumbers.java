//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学
// 👍 4794 👎 0


package leetcode.editor.cn;

//两数相加

public class P2AddTwoNumbers{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2AddTwoNumbers().new Solution();
		 ListNode l1 = new ListNode(1);
		 l1.next = new ListNode(2);
//		 l1.next.next = new ListNode(6);

		 ListNode l2 = new ListNode(1);
		 l2.next = new ListNode(2);
		 l2.next.next = new ListNode(6);

		 ListNode start = solution.addTwoNumbers(l1,l2);
		 while(start != null){
			 System.out.println(start.val);
			 start = start.next;
		 }
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode curr = head;
		int carry = 0;
		while(l1 != null || l2 != null){
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if(l1 != null){
				l1 = l1.next;
			}
			if(l2 != null){
				l2 = l2.next;
			}
		}
		if(carry > 0){
			curr.next = new ListNode(carry);
		}
		return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}