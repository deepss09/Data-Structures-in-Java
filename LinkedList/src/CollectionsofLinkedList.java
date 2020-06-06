import java.util.LinkedList;
public class CollectionsofLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.addFirst(30);
		list.add(40);
		System.out.println(list.size());

		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
