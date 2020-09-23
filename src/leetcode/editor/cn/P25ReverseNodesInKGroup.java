//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 701 👎 0


package leetcode.editor.cn;

//K 个一组翻转链表

public class P25ReverseNodesInKGroup{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P25ReverseNodesInKGroup().new Solution();
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		 head.next.next.next = new ListNode(4);
		 head.next.next.next.next = new ListNode(5);
		 ListNode start = solution.reverseKGroup(head,2);
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
    public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode rear = dummy;

		while(rear.next != null){
			for(int i = 0;rear != null && i < k;i++){
				rear = rear.next;
			}
			if(rear == null){
				break;
			}
			ListNode next = rear.next;
			rear.next = null;
			ListNode start = pre.next;
			pre.next = reverse(start);

			start.next = next;
			pre = start;
			rear = pre;
		}
		return dummy.next;
    }

	private ListNode reverse(ListNode head) {
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