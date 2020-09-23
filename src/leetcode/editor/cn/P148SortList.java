//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 705 👎 0


package leetcode.editor.cn;

//排序链表

public class P148SortList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P148SortList().new Solution();
		 ListNode head = new ListNode(3);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(4);
		 head.next.next.next = new ListNode(5);
		 head.next.next.next.next = new ListNode(1);
		 ListNode start = solution.sortList(head);
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
    public ListNode sortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode slow = head,fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tem = slow.next;
		slow.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(tem);

		ListNode sort = new ListNode(-1);
		ListNode pre = sort;

		while(right != null && left != null){
			if(right.val < left.val){
				pre.next = right;
				right = right.next;
			}else{
				pre.next = left;
				left = left.next;
			}
			pre = pre.next;
		}
		pre.next = left != null ? left:right;
		return sort.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}