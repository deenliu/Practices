package leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author deenliu
 *
 */
public class MergeTwoSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null, move;
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			head = l2;
			l2 = l2.next;
		} else if (l2 == null) {
			head = l1;
			l1 = l1.next;
		} else if (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head = l1;
				l1 = l1.next;
			} else {
				head = l2;
				l2 = l2.next;
			}
		}
		move = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				move.next = l1;
				move = move.next;
				l1 = l1.next;
			} else {
				move.next = l2;
				move = move.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			move.next = l1;
			move = move.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			move.next = l2;
			move = move.next;
			l2 = l2.next;
		}
		return head;
	}

}
