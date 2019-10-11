package 금요일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class 염라대왕의이름정렬 {

	// 이름 길이 짧을수록 앞에
	// 같은 길이이면 사전순
	// 같은 이름은 하나만 남기기

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int TC;
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();

			for (int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			
			//set잇는걸 리스트에
			LinkedList<String> li=new LinkedList<>();
			li.addAll(set);
			// 이름짧은순으로정렬=>같은 길이이면 사전순
			Collections.sort(li,new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					int ret=0;
					if(o1.length()-o2.length()>0) ret=1;
					else if(o1.length()-o2.length()==0) {
						if(o1.compareTo(o2)>0) ret=1;
						else if(o1.compareTo(o2)==0) ret=0;
						else ret=-1;
					}else ret=-1;
					
					return ret;
				}
			});
			System.out.println("#"+tc);
			StringBuilder sb=new StringBuilder();
			
			for (int i = 0; i < li.size(); i++) {
				sb.append(li.get(i)).append("\n");
			}
			bw.write(sb.toString());
			bw.flush();
		} // tc
		bw.close();
	}

}
