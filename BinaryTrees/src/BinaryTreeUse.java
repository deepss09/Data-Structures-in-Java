import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreeUse {
	public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root,int data){
		if(root == null) {
			return null;
		}
		if(root.data == data) {
	ArrayList<Integer> output = new ArrayList<>();
	output.add(root.data);
	return output;
	}
	
	ArrayList<Integer> leftOutput = getRootToNodePath(root.left,data);
	if(leftOutput!=null) {
	leftOutput.add(root.data);
	return leftOutput;
}

   ArrayList<Integer> rightOutput = getRootToNodePath(root.right,data);
   if(rightOutput!=null) {
   rightOutput.add(root.data);
   return rightOutput;
   }
   else {
	   return null;
   }
   }
	public static pair<Boolean,pair<Integer,Integer>> isBST2(BinaryTreeNode<Integer> root){
		if(root == null) {
			pair<Boolean,pair<Integer,Integer>> output = new pair<Boolean,pair<Integer,Integer>>();
			output.first = true;
			output.second = new pair<Integer,Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
			return output;
		}
		pair<Boolean,pair<Integer,Integer>> isLeftBST = isBST2(root.left);
		pair<Boolean,pair<Integer,Integer>> isRightBST = isBST2(root.right);
		int min = Math.min(root.data, Math.min(isLeftBST.second.first,isRightBST.second.first));
		int max =  Math.max(root.data, Math.max(isLeftBST.second.second,isRightBST.second.second));
		boolean isBST = (root.data < isLeftBST.second.second)
				&& (root.data >= isRightBST.second.first)
				&& isLeftBST.first && isRightBST.first;
		pair<Boolean,pair<Integer,Integer>> output = new pair<Boolean,pair<Integer,Integer>>();
		output.first = isBST;
		output.second = new pair<Integer,Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;
	}
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
	int leftMax = maximum(root.left);
	int rightMin = minimum(root.right);
	if(root.data < leftMax) {
		return false;
	}
	if(root.data > rightMin) {
		return false;
	}
	boolean isLeftBST = isBST(root.left);
	boolean isRightBST = isBST(root.right);
	if(isLeftBST && isRightBST) {
		return true;
	}
	else {
		return false;
	}
	}
	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
	return Math.max(root.data,Math.max(maximum(root.left), maximum(root.right)));
	}
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
	return Math.min(root.data,Math.min(minimum(root.left), minimum(root.right)));
	}
	public static BinaryTreeNode<Integer> buildTreeHelper(int in[],int pre[],int inS,int inE,int preS,int preE) {
		if(inS >= inE) {
			return null;
		}
	int rootData = pre[preS];
	BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
	int rootIndex = -1;
	for(int i = inS;i<=inE;i++) {
		if(in[i] == rootData) {
			rootIndex = i;
			break;
		}
	}
	if(rootIndex == -1) {
		return null;
	}
	int leftInS = inS;
	int leftInE = rootIndex - 1;
	int leftPreS = preS +1;
	int leftPreE = leftInE - leftInS + leftPreS;
	int rightInS = rootIndex + 1;
	int rightInE = inE;
	int rightPreS = leftPreE + 1;
	int rightPreE = preE;
	root.left = buildTreeHelper(in,pre,leftInS,leftInE,leftPreS,leftPreE);
	root.right = buildTreeHelper(in,pre,rightInS,rightInE,rightPreS,rightPreE);
	return root;
	}
	
	public static BinaryTreeNode<Integer> buildTree(int in[],int pre[]) {
		return buildTreeHelper(in,pre,0,in.length -1, 0, pre.length - 1);
	}
	public static pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root){
		if(root == null) {
			pair<Integer,Integer> output = new pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
	 pair<Integer,Integer> lo= heightDiameter(root.left);
	 pair<Integer,Integer> ro= heightDiameter(root.right);
	 int height = 1 + Math.max(lo.first, ro.first);
	 int option1 = lo.first + ro.first;
	 int option2 = lo.second;
	 int option3 = ro.second;
	 int diameter = Math.max(option1, Math.max(option2, option3));
	 pair<Integer,Integer> output = new pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	 
	}
	 public static int diameter(BinaryTreeNode<Integer> root) {
		 if(root == null) {
			 return 0;
		 }
	int option1 = height(root.left) + height(root.right);
	int option2 = diameter(root.left);
	int option3 = diameter(root.right);
	return Math.max(option1, Math.max(option2,option3));
	 }
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) { 
		return 0;
	}
	 int lh = height(root.left);
	 int rh = height(root.right);
	 return 1 + Math.max(lh, rh);
	}
	public static int countNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
	int ans = 1;
	ans+= countNodes(root.left);
	ans+= countNodes(root.right);
	return ans;
	}
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		QueueUsingLL2<BinaryTreeNode<Integer>> q = new QueueUsingLL2<>();
	    q.enqueue(root);
	        while(!q.isEmpty()){
	           BinaryTreeNode<Integer> current = null;
	            try{
	        current = q.dequeue();    
			 
		} catch (QueueEmptyException2 e) {
		   e.printStackTrace();
		}
	        String toBePrinted = current.data+":";
		 if(current.left != null) {
			 toBePrinted+= "L" + current.left.data + ",";
	         q.enqueue(current.left);
		 }
	            else{
	                toBePrinted+= "L:-1";
	            }
		  if(current.right !=null) {
			  toBePrinted+= "R" + current.right.data + ",";
	          q.enqueue(current.right);
		  }
	            else{
	                toBePrinted+= "R:-1";
	            }
	        System.out.println(toBePrinted);
	        }
	    }
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		 Scanner s = new Scanner(System.in);
		 QueueUsingLL2<BinaryTreeNode<Integer>> pendingNodes= new QueueUsingLL2<>();
		 System.out.println("Enter root data");
		 int rootData = s.nextInt();
		 if(rootData == -1) {
			 return null;
		 }
	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
	pendingNodes.enqueue(root);
	
	while(!pendingNodes.isEmpty()) {
		BinaryTreeNode<Integer> front;
	try {
		 front =	pendingNodes.dequeue();
		 
	} catch (QueueEmptyException2 e) {
	   return null;
	}
	System.out.println("Enter leftChild" + front.data);
	int leftChild = s.nextInt();
		if(leftChild != -1) {
	    BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
		pendingNodes.enqueue(child);
		front.left = child;
	}
	System.out.println("Enter rightChild" + front.data);
	int rightChild = s.nextInt();
		if(rightChild != -1) {
	    BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);	
		pendingNodes.enqueue(child);
		front.right = child;
	}
	}
	return root;
	}

	public static void printTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
	 String toBePrinted = root.data+" ";
	 if(root.left != null) {
		 toBePrinted+= "L" + root.left.data + ",";
	 }
	  if(root.right !=null) {
		  toBePrinted+= "R" + root.right.data + ",";
	  }
	  System.out.println(toBePrinted);
	  printTree(root.left);
	  printTree(root.right);
	  }
    public static BinaryTreeNode<Integer >takeInput(Scanner s) {
    	int rootData;
    	System.out.println("Enter root data");
    	rootData = s.nextInt();
    	if(rootData == -1) {
    		return null;
    	}
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
    root.left = takeInput(s);
    root.right = takeInput(s);
    return root;
    }
	public static void main(String[] args) {
//      Scanner s = new Scanner(System.in);
//      BinaryTreeNode<Integer> root = takeInputLevelWise();
//      printLevelWise(root);
//      System.out.println(countNodes(root));
//      System.out.println("diameter :" + heightDiameter(root).second);
//      System.out.println("height :" + heightDiameter(root).first);
//      System.out.println("diameter :" + diameter(root));
		int in[] = {4,2,1,5,3,7};
		int pre[] = {1,2,4,5,3,7};
		BinaryTreeNode<Integer> root = buildTree(in,pre);
		printTree(root);
	}
}
//      s.close();
		
		
		
		//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//		root.left = node1;
//		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//         root.right = node2;
	


