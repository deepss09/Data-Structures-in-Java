
public class insertLLR {

	public static Node<Integer> insertR(Node<Integer> head, int pos, int elem){
		if(pos == 0) {
		Node<Integer> newNode = new Node<>(elem);
		newNode.next = head;
		return newNode;
		}
		if(head == null) {
			return head;
		}
	   head.next= insertR(head.next,pos-1,elem);
	   return head;
	}
}
