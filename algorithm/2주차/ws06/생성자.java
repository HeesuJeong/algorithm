package edu.ssafy.ws06;

class Super {
	int data = 10;

	public void print() {
		System.out.println(data);
	}
}

class Child extends Super {
	int data = 20;

	public void print() {
		int data = 30;
		System.out.println(data);
		System.out.println(this.data);
		System.out.println(super.data);
		super.print();
	}
}

public class 생성자 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child();
		c.print();
		
		//동적 바인딩 되어 child의 print
		Super p=new Child();
		p.print();
	}

}
