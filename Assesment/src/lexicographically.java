import java.util.*;
public class lexicographically {
		 
	public static void sortfunc(String arr[],int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n -i - 1; j++) {

                if (arr[i].compareTo(arr[j]) > 0) {

                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String str[] = new String[n];
		for(int i=0;i<n;i++) {
			str[i] = s.next();
		}
		sortfunc(str,n);
		for(int i=0;i<n;i++) {
			System.out.println(str[i]);
		}
		}
	
	}
	


