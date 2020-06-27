
public class Question1 {

	static void printNcR(int n, int r) { 
		  
        long p = 1, k = 1;   
        if (n - r < r) { 
            r = n - r; 
        } 
  
        if (r != 0) { 
            while (r > 0) { 
                p *= n; 
                k *= r; 
   
                long m = __gcd(p, k); 
 
                p /= m; 
                k /= m; 
  
                n--; 
                r--; 
            }   
        } else { 
            p = 1; 
        } 
        System.out.println(p); 
    } 
  
    static long __gcd(long n1, long n2) { 
        long gcd = 1; 
  
        for (int i = 1; i <= n1 && i <= n2; ++i) { 
            if (n1 % i == 0 && n2 % i == 0) { 
                gcd = i; 
            } 
        } 
        return gcd; 
    }  
    public static void main(String[] args) { 
        int n = 3, r = 2; 
  
        printNcR(n, r); 
  
    } 
} 
	