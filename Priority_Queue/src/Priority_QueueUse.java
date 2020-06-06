
public class Priority_QueueUse {

	private static void insertVirtualHeap(int arr[],int i) {
		int childIndex = i;
		int parentIndex = (childIndex -1)/2;
		while(childIndex > 0) {
			if(arr[childIndex] < arr[parentIndex]) {
				int temp = arr[childIndex];
				arr[childIndex] = arr[parentIndex];
				arr[parentIndex] = temp;
				childIndex = parentIndex;
				parentIndex = (childIndex -1)/2;
			}
			else
			{
			return;	
			}
		}
	}
	private static int removeMinFromVirtualHeap(int arr[],int heapSize) {
		int temp = arr[0];
		arr[0] = heapSize - 1;
		heapSize--;
		int index = 0;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		 while(leftIndex < heapSize) {
			 int minIndex = index;
			 if(arr[leftIndex] < arr[minIndex]) {
				 minIndex = leftIndex;
			 }
			 if(rightIndex < heapSize && arr[rightIndex] < arr[minIndex]) {
				 minIndex = rightIndex;
		 }
	      if(minIndex != index) {
	    	  int temp1 = arr[index];
	    	  arr[index] = arr[minIndex];
	    	  arr[minIndex] = temp1;
	    	   index = minIndex;
	  		   leftIndex = 2 * index + 1;
	  		   rightIndex = 2 * index + 2;
	      }
	      else {
	    	  break;
	      }
		 }
		return temp;
		 }
	
	
	public static void main(String[] args) throws PriorityQueueException {
		
	    int arr[]= {5,1,9,2,0,6};
	    for(int i=0;i<arr.length;i++) {
	    	insertVirtualHeap(arr,i);
	 
	    }
	    for(int i=0;i<arr.length;i++) {
	    	arr[arr.length - 1 - i] = removeMinFromVirtualHeap(arr,arr.length-i);
	    }
   for(int i=0;i<arr.length;i++) {
	    	System.out.println(arr[i] + " ");
    }
}
}
		
		
//		Priority_Queue pq = new Priority_Queue();
//		int arr[] = {5,1,9,2,0};
//        for(int i=0;i<arr.length;i++) {
//        	pq.insert(arr[i]);
//        }
//	while(!pq.isEmpty()) {
//		System.out.print(pq.removeMin()+" ");
//	}
//	System.out.println();
//	}

