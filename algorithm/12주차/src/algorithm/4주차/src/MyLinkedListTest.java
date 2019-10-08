class MyLinkedList{
	Node head;
	int size=0;
	void addToFirst(int data) {
		Node n=new Node(data);
		size++;
		if(head==null) head=n;
		else {
			n.link=head;
			head=n;
		}
	}
	
	void add(int idx,int data) {
		Node n=new Node(data);
		
		Node tmp=head;
		for (int i = 0; i < idx; i++) {
			tmp=tmp.link;
		}
		n.link=tmp.link;
		tmp.link=n;
		size++;
	}
	void addToLast(int data) {
		Node n=new Node(data);
		size++;
		if(head==null) head=n;
		else {
			Node tmp=head;
			while(tmp.link!=null) {
				tmp=tmp.link;
			}
			tmp.link=n;
		}
	}
	
	Node get(int idx) {
		if(size<=0||size<=idx) {
			return null;
		}
		else {
			Node tmp=head;
			for (int i = 0; i < idx; i++) {
				tmp=tmp.link;
			}
			return tmp;
		}
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		Node tmp=head;
		while(tmp!=null) {
			sb.append(tmp.data).append(" ");
			tmp=tmp.link;
		}
		return sb.toString();
	}
	static class Node{
		int data;
		Node link;
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data=data;
			this.link=null;
		}
	}
	
}
public class MyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//outer클래스의 inner static 클래스 접근하기
//		MyLinkedList.Node n1=new MyLinkedList.Node();
//		n1.data=10;
//		
//		MyLinkedList.Node n2=new MyLinkedList.Node();
//		n2.data=20;
//		n1.link=n2;
//		
//		MyLinkedList.Node n3=new MyLinkedList.Node();
//		n3.data=30;
//		n2.link=n3;
//		
//		MyLinkedList.Node n4=new MyLinkedList.Node();
//		n4.data=40;
//		n3.link=n4;
//		
//		n2=n3=n4=null;
//		
//		MyLinkedList.Node tmp=new MyLinkedList.Node();
//		tmp=n1;
//		while(tmp.link!=null) {
//			System.out.println(tmp.data+" ");
//			tmp=tmp.link;
//		}
//		System.out.println(tmp.data);
		
		MyLinkedList list=new MyLinkedList();
		list.addToFirst(10);
		list.addToFirst(20);
		list.addToFirst(30);
		list.addToLast(50);
		System.out.println(list);
		System.out.println(list.get(3).data);
		list.add(1, 40);
		System.out.println(list);
	}

}
