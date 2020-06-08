
public class MinStepsTo1 {

	public static int MinSteps(int n) {
		if(n == 1) {
			return 0;
		}
	int op1 = MinSteps(n-1);
	int min = op1;
	if(op1 < min) {
		min = op1;
	}
	if(n%3 == 0) {
		int op2 = MinSteps(n/3);
		if(op2 < min) {
			min = op2;
		}
	}
	if(n%2 == 0) {
		int op3 = MinSteps(n/2);
		if(op3 < min) {
			min = op3;
		}
	}
	return 1 + min;
	}
	public static int countStepsM(int n) {
			int storage[] = new int[n+1];
			return countStepsM(n,storage);
		}
	
	public static int countStepsM(int n, int[] storage) {
	          if(n == 0) {
	        	  storage[n] = 0;
	        	  return storage[n];
	          }
	       if(storage[n] != 0) {
	    	   return storage[n];
	       }
	      int op1 = countStepsM(n-1,storage);
	      int min = op1;
	      if(n%3 == 0) {
	    	  int op2 = countStepsM(n/3,storage);
	    	  if(op2 < min) {
	    		  min = op2;
	    	  }
	      }
	     if(n%2 == 0) {
	    	 int op3 = countStepsM(n/2,storage);
	    	 if(op3 < min) {
	    		 min = op3;
	    	 }
	     }
	     storage[n] = 1+min;
	     return storage[n];
	      }
	public static void main(String[] args) {
		int n = 100;
		System.out.println(MinSteps(n));
		System.out.println(countStepsM(n));

	}

}
