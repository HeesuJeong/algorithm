import java.util.Scanner;

public class 선형큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queue=new int[10];
		int front=-1;
		int rear=-1;
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.enQueue\n2.deQueue\n3.isEmpty\n0.End");
			int sel=sc.nextInt();
			if(sel==1) {
				//큐 삽입
				//rear하나 늘려 rear자리에 데이터 삽입
				int num=sc.nextInt();
				queue[++rear]=num;
			}
			else if(sel==2) {
				//큐에서 하나 꺼내어 출력
				//front 하나 늘려서 front자리의 데이터 인출
				System.out.println(queue[++front]);
			}
			else if(sel==3) {
				//큐의 공백여부 출력
				//front와 rear 같으면 공백
				if(rear==front) System.out.println("큐는 비어있습니다");
				else System.out.println("큐에 원소가 있습니다.");
			}
			else if(sel==0) {
				break;
			}
		}
	}

}
