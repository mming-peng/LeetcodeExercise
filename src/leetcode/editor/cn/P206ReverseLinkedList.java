//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1186 👎 0


package leetcode.editor.cn;

//反转链表

public class P206ReverseLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P206ReverseLinkedList().new Solution();
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		 head.next.next.next = new ListNode(4);
		 head.next.next.next.next = new ListNode(5);
		 ListNode start = solution.reverseList(head);
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
    public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		while(head != null){
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}