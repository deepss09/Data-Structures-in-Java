
public class EditDistance {

	public static int EditDistanceDP(String s, String t) {
		int m= s.length();
		int n= t.length();
		int storage[][] = new int[m+1][n+1];
		for(int j=0;j<=m;j++) {
			storage[0][j] = j;
		}
		for(int i=0;i<=n;i++) {
			storage[i][0] = i;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s.charAt(m-i) == t.charAt(n-j)) {
				storage[i][j] = storage[i-1][j-1];
			}
				else {
					storage[i][j] = 1+ Math.min(storage[i][j-1], Math.min(storage[i-1][j],storage[i-1][j-1]));
				}
			}
		}
		return storage[m][n];
	}
	public static void main(String[] args) {
		String s = "abcde";
		String t = "bacge";
		System.out.println(EditDistanceDP(s,t));

	}

}
