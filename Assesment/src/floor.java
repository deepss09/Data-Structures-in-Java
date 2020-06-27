
public class floor {

	static int countWays(int n, int m) 
    { 
        int count[] = new int[n + 1]; 
        count[0] = 0;  
        int i; 
        for (i = 1; i <= n; i++) { 
            if (i > m) 
                count[i] = count[i - 1] + count[i - m]; 
            else if (i < m || i == 1) 
                count[i] = 1; 
            else
                count[i] = 2; 
        }  
        return count[n]; 
    } 
    public static void main(String[] args) 
    { 
        int n = 2; 
        int m = 3; 
        System.out.println("Number of ways = "
                           + countWays(n, m)); 
    } 
} 
