import java.util.Arrays;
import java.util.Scanner;

public class 스타일리쉬들여쓰기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int p = 0;
		int q = 0;

		for (int tc = 1; tc <= TC; tc++) {
			p=sc.nextInt();
			q=sc.nextInt();
			String[] master=new String[p];
			String[] me=new String[q];
			for (int i = 0; i <p; i++) {
				master[i]=sc.next();
			}
			for (int i = 0; i <q; i++) {
				me[i]=sc.next();
			}
			
			int[] result=new int[q];
			Arrays.fill(result, -2);
			
			for (int r = 1; r <=20; r++) {
				for (int c = 1; c <=20; c++) {
					for (int s = 1; s <=20; s++) {
						//rcs조합이 마스터문장 모든 라인에 대해 수식 만족해?
						if(isOk(master,r,c,s)) {
							//System.out.println(r+c+s);
							//각 라인의 들여쓰기 계산 결과를 저장할 배열 준비
							//초기값을 -2로, -2는 계산 값이 없음을 의미
							//계산한 값이 나오면 그 값으로 대체
							//계산한 값이 또 나왔는데 -2가 아니라면 두 개 이상의 경우이므로 -1로 처리
							calIndent(me, r, c, s, result);
						}
						//해당 rcs로 스타일리쉬의 각 라인별 들여쓰기 계산
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int indent : result) {
				System.out.print(indent + " ");
			}
			System.out.println();
		} // tc

	}
	
	static void calIndent(String[] me, int r, int c, int s, int[] result) {
		int rCnt=0, cCnt=0, sCnt=0;
		for (int i = 0; i < me.length; i++) {
			//i번째 라인에 대해서 아직 계산한 인덴트가 없다면 계산값 넣어주자
			if(result[i]==-2) {
				result[i]=r*rCnt+s*sCnt+c*cCnt;
			}else {
				//처음이 아닌데 다른 경우의 들여쓰기 횟수가 계산되면 두가지 이상이므로 알 수 없다
				if(r*rCnt+s*sCnt+c*cCnt!=result[i]) {
					result[i]=-1;
				}
			}
			//다음 라인의 들여쓰기 검사하기 위해 현재 라인에서의 괄호 유무 체크
			for (char ch : me[i].toCharArray()) {
				switch(ch) {
				case '(': rCnt++; break;
				case ')': rCnt--; break;
				case '{': cCnt++; break;
				case '}': cCnt--; break;
				case '[': sCnt++; break;
				case ']': sCnt--; break;
				}
			}
		}
	}
	static boolean isOk(String[] master,int r,int c,int s) {
		int rCnt=0, cCnt=0, sCnt=0;
		for (int i = 0; i < master.length; i++) {
			//해당 문장의 시작 들여쓰기 . 갯수 세기
			int cnt=0;
			for (char ch : master[i].toCharArray()) {
				if(ch=='.') cnt++;
				else break;
			}
			//그 갯수가 지금까지 계사된 rCnt,sCnt,sCnt와 매개로 받은 rcs를 통한 계산값과 일치 하지 않으면 return false
			if(cnt!=r*rCnt+s*sCnt+c*cCnt)
			return false;
			//다음 라인의 들여쓰기를 검사하기 위해서 현재 라인에서의 괄호 유무를 체크
			for (char ch : master[i].toCharArray()) {
				switch(ch) {
				case '(': rCnt++; break;
				case ')': rCnt--; break;
				case '{': cCnt++; break;
				case '}': cCnt--; break;
				case '[': sCnt++; break;
				case ']': sCnt--; break;
				}
			}
		}
		//모든 라인이 끝날때까지 return false 안 당했다면 멀쩡하니깐 return true
		return true;
	}
}
