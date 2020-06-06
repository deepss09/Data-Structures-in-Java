
public class QueueUsingLL2<T> {
		 private Node1<T> front;
		      private Node1<T> rear;
		      private int size;  
			public QueueUsingLL2() {
		        front = null;
		        rear = null;
		        size= 0;
		    }
			public void enqueue(T data) {
		        Node1<T> newNode = new Node1<>(data);
		        if(rear == null && front == null){
		            rear = newNode;
		            front = newNode;
		        }
		        else{
		        rear.next = newNode;
		        rear = newNode;
		        }
		        size++;
			}
			public int size() {
		      return size;
			}

			public boolean isEmpty() {
		     return size() == 0;
			}

			public T dequeue() throws QueueEmptyException2 {
		           if(size == 0){
		               throw new QueueEmptyException2();
		           }
			  Node1<T> temp = front;
		       front = front.next;
		        if(size == 1){
		            front = null;
		            rear = null;
		        }
		       size--;
		       return temp.data; 
		    }
			public T front() throws QueueEmptyException2 {
		        if(size == 0){
		            throw new QueueEmptyException2();
		        }
			  return front.data;
		    }
		}

