package 금요일;

import java.util.LinkedList;
import java.util.Queue;

public class test2 {

	static Queue<Integer> q=new LinkedList<Integer>();
	static Queue<Integer> mv=new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q.add(99);
		q.add(77);
		mv=q;
		while(!mv.isEmpty()) {
			System.out.println(mv.poll());
		}
	System.out.println("======");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
