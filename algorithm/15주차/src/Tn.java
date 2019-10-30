
public class Tn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(T(1000));
	}

	private static int T(int n) {
		// TODO Auto-generated method stub
		if(n==1) return 1;
		return 3*T(n-1)+6;
	}

}
