
public class LinkedQueueTest {

	Node front;
	Node rear;
	void enQueue(int data) {
		Node tmp=new Node(data);
		
		if(front==null) {
			front=tmp;
			rear=tmp;
		}
		else {
			rear.link=tmp;
			rear=tmp;
		}
	}
	int deQueue() {
		if(front==null) {
			rear=null;
			return -1;
		}
		int resul=front.data;
		front=front.link;
		return resul;
	}
	
	class Node{
		int data;
		Node link;
		public Node(int d) {
			// TODO Auto-generated constructor stub
			this.data=d;
			this.link=null;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueueTest qt=new LinkedQueueTest();
		qt.enQueue(10);
		qt.enQueue(20);
		System.out.println(qt.deQueue());
		System.out.println(qt.deQueue());
		System.out.println(qt.deQueue());
	}

}
