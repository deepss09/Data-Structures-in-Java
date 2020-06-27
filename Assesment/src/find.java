
public class find {
	
	 private static int findX(int n, int k) 
	    { 
	        int r = n, v, u; 
	  
	        int m = (int)Math.sqrt(k) + 1; 
	 
	        for (int i = 2; i <= m && k > 1; i++) { 
	            if (i == m) { 
	                i = k; 
	            } 
	  
	            for (u = v = 0; k % i == 0; v++) { 
	                k /= i; 
	            } 
	  
	            if (v > 0) { 
	                int t = n; 
	                while (t > 0) { 
	                    t /= i; 
	                    u += t; 
	                } 
	 
	                r = Math.min(r, u / v); 
	            } 
	        } 
	  
	        return r; 
	    } 
	  
	    // Driver Code 
	    public static void main(String args[]) 
	    { 
	        int n = 5; 
	        int k = 2; 
	  
	        System.out.println(findX(n, k)); 
	    } 
	} 
	