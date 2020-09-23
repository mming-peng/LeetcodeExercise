//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 599 👎 0


package leetcode.editor.cn;

//两两交换链表中的节点

public class P24SwapNodesInPairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P24SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode preHead = dummy;
		while(head != null && head.next != null){
			ListNode first = head;
			ListNode second = head.next;

			preHead.next = second;
			first.next = second.next;
			second.next = first;

			preHead = first;
			head = first.next;
		}

		return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}