package 수요일;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private char[] tree;
	int max_depth;
	public BinaryTree(int max_depth) {
		tree = new char[1 << max_depth];
		this.max_depth=max_depth;
	}

	public void setRoot(char data) {
		tree[1]=data;
	}

	public void setLeft(int parent, char data) {
		tree[parent*2]=data;
	}
	public void setRight(int parent, char data) {
		tree[parent*2+1]=data;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < max_depth; i++) {
			for (int j = 0; j < (1<<i); j++) {
				sb.append(tree[(1<<i)+j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public void preorder(int node) {
		System.out.print(tree[node]);
		//char디폴트는 '\0'
		if(node*2<tree.length&&tree[node*2]!='\0')
			preorder(node*2);
		if(node*2+1<tree.length&&tree[node*2+1]!='\0')
			preorder(node*2+1);
	}
	public void postorder(int node) {
		//char디폴트는 '\0'
		if(node*2<tree.length&&tree[node*2]!='\0')
			postorder(node*2);
		if(node*2+1<tree.length&&tree[node*2+1]!='\0')
			postorder(node*2+1);
		System.out.print(tree[node]);
	}
	public void inorder(int node) {
		//char디폴트는 '\0'
		if(node*2<tree.length&&tree[node*2]!='\0')
			inorder(node*2);
		System.out.print(tree[node]);
		if(node*2+1<tree.length&&tree[node*2+1]!='\0')
			inorder(node*2+1);
	}
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree(4);
		tree.setRoot('A');
		tree.setLeft(1, 'B');
		tree.setRight(1, 'C');
		tree.setLeft(2, 'D');
		tree.setRight(2, 'E');
		tree.setLeft(3, 'F');
		tree.setRight(3, 'G');
		tree.setLeft(4, 'H');
		tree.setRight(4, 'I');
		tree.setLeft(5, 'J');
		tree.setRight(5, 'K');
		tree.setLeft(6, 'L');
		tree.setRight(6, 'M');
		System.out.println(tree);
		
		System.out.println("preorder입니다");
		tree.preorder(1);
		System.out.println("\n\ninorder입니다");
		tree.inorder(1);
		System.out.println("\n\npostorder입니다");
		tree.postorder(1);
		
		Queue<Integer> q=new LinkedList<Integer>();
		Stack<Integer> s=new Stack<>();
	}
}

