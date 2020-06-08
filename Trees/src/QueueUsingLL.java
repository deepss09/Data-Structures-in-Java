
public class QueueUsingLL<T> {
	
		 private Node<T> front;
		      private Node<T> rear;
		      private int size;  
			public QueueUsingLL() {
		        front = null;
		        rear = null;
		        size= 0;
		    }
			public void enqueue(T data) {
		        Node<T> newNode = new Node<>(data);
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

			public T dequeue() throws QueueEmptyException {
		           if(size == 0){
		               throw new QueueEmptyException();
		           }
			  Node<T> temp = front;
		       front = front.next;
		        if(size == 1){
		            front = null;
		            rear = null;
		        }
		       size--;
		       return temp.data; 
		    }
			public T front() throws QueueEmptyException {
		        if(size == 0){
		            throw new QueueEmptyException();
		        }
			  return front.data;
		    }
		}

