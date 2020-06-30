import java.util.Arrays;
import java.util.Scanner;

class Edges implements Comparable<Edges>{
	int source;
	int dest;
	int weight;
	
	@Override
	public int compareTo(Edges o) {
		return this.weight - o.weight;
	}
}

public class KruskalAlgo {
	public static int findParent(int v, int parent[]) {
		if(parent[v] == v) {
			return v;
		}
		return findParent(parent[v], parent);
	}

	public static void kruskals(Edges input[], int n) {
		Arrays.sort(input);
		
		Edges output[] = new Edges[n-1];
		int parent[] = new int[n];
		for(int i=0;i<n;i++) {
			parent[i] = i;
		}
		int count =0;
		int i = 0;
		while(count != n-1) {
			Edges currentEdge = input[i];
			
			int sourceParent = findParent(currentEdge.source, parent);
			int destParent = findParent(currentEdge.dest, parent);
			if(sourceParent != destParent) {
				output[count] = currentEdge;
				count++;
				parent[sourceParent] = destParent; 
			}
			i++;
		}
		for(int j=0;j<n-1;j++) {
			if(output[j].source < output[j].dest) 
			System.out.println(output[j].source + " " + output[j].dest + " " + output[j].weight);
			else
				System.out.println(output[j].source + " " + output[j].dest + " " + output[j].weight);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int E = s.nextInt();
		
		Edges input[] = new Edges[E];
		for(int i=0;i<E;i++) {
			input[i] = new Edges();
			input[i].source = s.nextInt();
			input[i].dest = s.nextInt();
			input[i].weight = s.nextInt();
		}
         kruskals(input,n);
	}

}
