
public class BitMask_powerset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// k<<n = k*2^n
		
		//사과 오렌지 배를 모든 경우의 수로 뽑아보자.
		//원소 3개니깐 8가지의 방법이 있다.
		String[] fruits= {"사과","오렌지","베"};
		/*for (int i = 0; i < (1<<3); i++) {
			//if((1<<0)!=0)
			if((1&i)!=0)
				System.out.print(fruits[0]+" ");
			//if((1<<1)!=0)
			if((2&i)!=0) 
				System.out.print(fruits[1]+" ");
			//if((1<<2)!=0)
			if((4&i)!=0) 
				System.out.print(fruits[2]+" ");
			System.out.println();
		}*/
		
		for (int i = 0; i < (1<<3); i++) {
			for(int j=0;j<fruits.length;j++) {
				if(((1<<j)&i)!=0){
					System.out.print(fruits[j]);
				}
				System.out.println();
			}
		}
	}

}
