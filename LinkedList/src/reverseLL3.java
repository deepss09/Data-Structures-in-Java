
public class reverseLL3 {

	 public static Node<Integer> reverseLL(Node<Integer> head){
		 if(head == null || head.next == null) {
			 return head;
		 }
	 Node<Integer> reverseTail = head.next;
	 Node<Integer> smallAns = reverseLL(head.next);
	 reverseTail.next = head;
	 head.next = null;
	 
	 return smallAns;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
