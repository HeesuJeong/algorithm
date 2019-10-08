import java.util.Scanner;
import java.util.Vector;

public class 쿵쿵따 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5010];
		int N=0;
		int K=0;
		Vector<Integer> v=new Vector<>();
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		int size=0;
		for (int i = 1; i <=N; i++) {
			arr[i]=i;
		}
		int i=1;
		while(size!=N) {
			int cnt=0;
			while(cnt<=K) {
				if(arr[i]!=-1) {
					cnt++;
				}
				if(cnt==K) {
					v.add(arr[i]);
					arr[i]=-1;
					size++;
					break;
				}
				i++;
				if(i==N+1) i=1;
			}
			i++;
			if(i==N+1) i=1;
		}
		System.out.print("<");
		for (int j = 0; j < v.size()-1; j++) {
			System.out.print(v.get(j)+", ");
		}
		System.out.println(v.get(v.size()-1)+">");
	}

}
