package quickSort;

public class QuickSort {
	public static void quickSort(int[] input, int sI, int eI) {
		if(sI>=eI){
            return;
        }
        if(sI<eI){
		int pivot = partition(input,sI,eI);
       
        quickSort(input,sI,pivot-1);
        quickSort(input,pivot+1,eI);
  }
	}
	
    public static int partition(int[] input, int sI, int eI){
        int pivot = input[sI];
        int count = count + 1;
        int pivotPos = sI+count;
        int i,j;
        while(i<pivotPos && j>pivotPos) {
            if(input[i]<input[j]){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
            }
            else {
           int temp = input[j];
            input[j] = input[i];
            input[i] = temp;
           j++;
           return pivotPos;
            }
            
        }
    }
