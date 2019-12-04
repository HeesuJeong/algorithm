import java.util.Arrays;

public class а╤гу {

	static int[] arr= {1,2,3};
	static int[] brr=new int[2];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combi(0,0);
	}
	static void combi(int n,int c) {
		if(c==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		if(n==arr.length) return;
		brr[c]=arr[n];
		combi(n+1,c+1);
		combi(n+1,c);
	}
}
