
public class reverseIterative {

	public static Node<Integer> reverseI(Node<Integer> head){
		Node<Integer> curr = head;
		Node<Integer> prev = null;
		Node<Integer> temp;
		
		while(curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			
		}
	return prev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
