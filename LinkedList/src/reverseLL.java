
public class reverseLL {

	public static Node<Integer> reverseR(Node<Integer> head) {
		if(head == null || head.next == null) {
			return head;
		}
	  Node<Integer> finalhead = reverseR(head.next);
	  Node<Integer> temp = finalhead;
	  while(temp.next!=null) {
		  temp = temp.next;
	  }
	  temp.next = head;
	  head.next = null;
	  return finalhead;
	  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
