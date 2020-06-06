import java.util.Comparator;
import java.util.PriorityQueue;

public class InbuiltPriorityQueue {
    class MinPQComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
             if(o1 < o2) {
            	 return -1;
             }
             else if(o1 > o2){
            	 return 1;
             }
		return 0;
		}
    	
    }
	
    public static void sortKSorted(int arr[],int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i=0;
		for(;i<k;i++) {
			pq.add(arr[i]);
		}
	for(;i<arr.length;i++) {
		arr[i - k] = pq.remove();
		pq.add(arr[i]);
		
	}
	for(int j=arr.length - k ; j<arr.length; j++) {
		arr[j] = pq.remove();
	}
	}
	public static void main(String[] args) {
       int arr[] = {2,4,1,9,6,8};
       int k = 3;
       sortKSorted(arr,k);
       for(int i =0;i<arr.length;i++) {
    	   System.out.print(arr[i] + " ");
       }
	}	
}	
		
		//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		int arr[]= {5,1,6,0,9};
//		for(int i=0;i<arr.length;i++) {
//			pq.add(arr[i]);
//		}
//       while(! pq.isEmpty()) {
//    	   System.out.print(pq.remove() + " ");
//       }
//	}


