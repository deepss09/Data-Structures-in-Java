
public class TriesUse {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("this");
		t.add("news");
		System.out.println(t.search("news"));

	}

}
