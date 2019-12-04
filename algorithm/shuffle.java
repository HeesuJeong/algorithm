
import java.util.Scanner;

public class shuffle {
	static int TC;
	static int n;
	static int[] cards;
	static Scanner sc=new Scanner(System.in);
	static int min=Integer.MAX_VALUE;
	static boolean chk;
	static int result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			n=sc.nextInt();
			cards=new int[n];
			chk=false;
			result=0;
			
			for (int i = 0; i <n; i++) {
				cards[i]=sc.nextInt();
			}
			//정렬된 상태
			if(asc()||desc()) {
				System.out.println("#"+tc+" "+(0));
			}else {
				//정렬 안 되어 있는 경우 셔플 필요
				permutation(0);
				if(chk==true) {
					//정렬 성공시
					System.out.println("#"+tc+" "+result);
				}else {
					//정렬 실패시
					System.out.println("#"+tc+" "+(-1));
				}
			}
		}//tc
	}
	//중복순열 부분
	static void permutation(int c) {
		if(chk) return;
		//총 5번만 셔플
		
		if(c==5) {
			//chk=false;
			//result=Math.min(result, c);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			//System.out.println("여기야???????");
			shuffle(i);
			if(asc()||desc()) {
				chk=true;
				result=Math.min(result, c);
				return;
			}
			permutation(c+1);
			if(chk) return;
		}
	}
	static void shuffle(int x) {
		int[] resul=new int[n];
		int half=n/2;
		int[] leftCards=new int[half];
		int[] rightCards=new int[half];
		int leftidx=0;
		int rightidx=0;
		int idx=0;
		if(x<half) {
			leftidx=0;
			rightidx=-(half-x-1);
		}else {
			leftidx=-(x-half+1);
			rightidx=0;
		}
		for (int i = 0; i < cards.length; i++) {
			if(i<half) leftCards[i]=cards[i];
			else rightCards[i-half]=cards[i];
		}
		while(!(leftidx==3&&rightidx==3)) {
			System.out.println("무한루프");
			if(leftidx>=0&&leftidx<half) {
				resul[idx++]=leftCards[leftidx++];
				System.out.println("왼쪽?");
			}
			if(rightidx>=0&&rightidx<half) {
				resul[idx++]=rightCards[rightidx++];
				System.out.println("오른쪽?");
			}
			if(leftidx<0) leftidx++;
			if(rightidx<0) rightidx++;
		}
		
		cards=resul.clone();
	}
	static boolean asc() {
		for (int i = 0; i < cards.length; i++) {
			if(cards[i]!=i+1) return false;
		}
		return true;
	}
	static boolean desc() {
		int compare=n;
		for (int i = 0; i < cards.length; i++) {
			if(cards[i]!=compare) return false;
			compare--;
		}
		return true;
	}
}
