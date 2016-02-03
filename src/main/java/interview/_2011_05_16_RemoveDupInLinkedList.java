package interview;

import util.MyLinkedListNode;

/*
 * input : singly linked list에서 중복된 원소를 제거한다. ( in-place 로 )
 *         테스트의 편의상 중복된 것 중 맨 처음 원소만 남기고 나머지를 제거하도록 한다. 
 */
public class _2011_05_16_RemoveDupInLinkedList {
	public static void removeDupInLinkedList(MyLinkedListNode s) {
		MyLinkedListNode curr = s;
		while (curr != null) {
			removeDup(curr);
			curr = curr.next;
		}
	}

	private static void removeDup(MyLinkedListNode s) {
		MyLinkedListNode prev = s;
		MyLinkedListNode curr = s.next;
		
		while (curr != null) {
			if (curr.value == s.value) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
	}
}

/*
 * in-place로 하지 않을 경우는 당연히 hash table을 쓰면 O(n)에 가능하다.
 * in-place로 하려면 O(n^2)이 된다. 구현상세에 유의한다.
 */
