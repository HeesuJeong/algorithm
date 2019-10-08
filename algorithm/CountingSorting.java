import java.util.Arrays;

//각 숫자별로 빈도를 세고 나보다 작은 수의 갯수만큼의 다음 자리가 내자리!
//0부터N까지의 인덱스를 갖는 배열을 만들고 각 인덱스별로 해당 숫자의 빈도를 기록(N은 정렬 대상 중 가장 큰 수)
//누적값
//자신의 위치는 -1하고 배치
public class CountingSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0,4,1,3,1,2,4,1};
		//0 1 1 1 2 3 4
		int[] cntArr=new int[5];
		int[] resul=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			cntArr[arr[i]]++;
		}
		int sum=0;
		for (int i = 0; i < cntArr.length; i++) {
			sum+=cntArr[i];
			cntArr[i]=sum;
		}
		//System.out.println(Arrays.toString(cntArr));
		for(int i=arr.length-1;i>=0;i--) {
				resul[--cntArr[arr[i]]]=arr[i];
		}
		System.out.println(Arrays.toString(resul));
	}

}
