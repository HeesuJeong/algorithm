import java.util.Scanner;

public class 원형큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] queue = new int[4];
		int front = 0;
		int rear = 0;
		int N = queue.length;

		System.out.println(N);
		while (true) {
			System.out.println("1.enQueue\n2.deQueue\n3.isEmpty\n4.isFull\n0.End");
			int sel = sc.nextInt();
			if (sel == 1) {
				// 큐 삽입
				// rear하나 늘려 rear자리에 데이터 삽입
				if (front == (rear + 1) % N) {
					System.out.println("Full!!");
				} else {
					int num = sc.nextInt();
					rear = (rear + 1) % N;
					queue[rear] = num;
				}
			} else if (sel == 2) {
				// 큐에서 하나 꺼내어 출력
				// front 하나 늘려서 front자리의 데이터 인출
				if(front==rear) {System.out.println("empty!");}
				else {
					front=(front+1)%N;
					System.out.println(queue[front]);
				}
			} else if (sel == 0) {
				break;
			}
		}
	}

}