package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 보물상자의비밀번호_개선한코드 {

	// 4의 배수 N(<=28)개의 숫자 주어진다(0~F)
	// 4면이므로 N/4길이의 str이 생긴다.
	// N/4번 돈다.
	static int TC;
	static int N;
	static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			//중복제거 및 정렬을 위해 treeset사용
			TreeSet<String> ts = new TreeSet<>();
			String str=br.readLine();
			String tmp="";
			for (int i = 0; i < N / 4; i++) {
				int idx = 0;
				for (int j = 0; j < 4; j++) {
					ts.add(str.substring(idx,idx+N/4));
					idx+=N/4;
				}
				tmp="";
				tmp+=str.charAt(str.length()-1);
				tmp+=str.substring(0,str.length()-1);
				str=tmp;
				
			}
			//treeset은 인덱스 접근 안 되므로 
			//list에 옮겨두쟈
			//생성자에 넣으면 값이 저장되는 리스트가 생긴다!
			ArrayList<String> li=new ArrayList<>(ts);
			//Integer.parsInt에 원하는 string과 원하는 진수를 넣으면
			//string을 해당 진수에 맞게 숫자로 변형해준다
			System.out.println("#"+tc+" "+Integer.parseInt(li.get(li.size()-K),16));
		} // tc
	}

}
