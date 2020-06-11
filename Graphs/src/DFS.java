import java.util.Scanner;

public class DFS {


	public static void printDFS(int edges[][],int sv, boolean visited[]) {
		System.out.println(sv);
		visited[sv] = true;
		int n= edges.length;
		for(int i=0;i<n;i++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				printDFS(edges,i,visited);
			}
		}
	}
		public static void DFS(int edges[][],int sv) {
			boolean visited[] = new boolean[edges.length];
			printDFS(edges,sv,visited);
		}
		public static void printBFS(int edges[][],int sv, boolean visited[]) {
		  QueueUsingLL<Integer> q = new QueueUsingLL<>();
		  q.enqueue(sv);
		  int n = edges.length;
		  visited[sv] = true;
		  while(!q.isEmpty()) {
			  int front;
			  try {
			 front = q.dequeue();
			} catch (QueueEmptyException e) {
				return;
			}
			  System.out.println(front);
			  for(int i=0;i<n;i++) {
			  if(edges[front][i] == 1 && !visited[i]) {
				  q.enqueue(i);
				  visited[i] = true;
			  }
			  }
		  }
		  }
		  public static void BFS(int edges[][],int sv) {
				boolean visited[] = new boolean[edges.length];
				for(int i=0;i<edges.length;i++) {
					if(!visited[i]) {
				printBFS(edges,0,visited);
					}
				}
			}
	public static void main(String[] args) {
		int n;
		int e;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		e = s.nextInt();
		int edges[][] = new int[n][n];
		for(int i=0;i<e;i++) {
	      int fv = s.nextInt();
	      int sv = s.nextInt();
		edges[sv][fv] = 1;
		edges[fv][sv] = 1;
		
		}
		System.out.println("DFS");
		DFS(edges,0);
		System.out.println("BFS");
		BFS(edges,0);
	}

}
