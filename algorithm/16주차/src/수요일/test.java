package 수요일;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <=12; i++) {
			for (int j = 1; j <=12; j++) {
				if(i==j) System.out.print("0 ");
				else System.out.print(((i*j)%15)+" ");
			}
			System.out.println();
		}
	}

}
