import java.util.Scanner;

public class 스택 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stack = new int[5];
		int top = -1;

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Push\n 2.Pop\n 0.종료");

			int num = sc.nextInt();
			if (num == 1) {
				if (top < stack.length - 1) {
					int input = sc.nextInt();
					stack[++top] = input;
				} else {
					System.out.println("stack Overflow!!");
				}
			} else if (num == 2) {
				if (top >= 0) {
					System.out.println(stack[top--]);
				} else {
					System.out.println("EmptyStackException!!");
				}
			} else if (num == 0) {
				break;
			}
		} // while
	}

}
