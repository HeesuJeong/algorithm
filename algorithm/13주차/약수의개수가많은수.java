package 금요일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class 약수의개수가많은수 {

	static int[] arr;
	static int[] command;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int TC =Integer.parseInt(br.readLine());
		int max = 0;
		command=new int[TC];
		for (int i = 0; i < TC; i++) {
			int tmp = Integer.parseInt(br.readLine());
			command[i]=tmp;
			max = Math.max(max, tmp);			
		}
		arr=new int[max+1];
		maxValue=0;
		maxCnt=0;
		for (int i = 1; i <=max; i++) {
			func(i);
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < command.length; i++) {
			sb.append("#").append(i+1).append(" ").append(arr[command[i]]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int maxValue;
	static int maxCnt;
	
	private static void func(int x) {
		// TODO Auto-generated method stub
		int root=(int)Math.sqrt(x);
		int cnt=0;
		for (int i = 1; i <=root; i++) {
			if(x%i==0) {
				if(x/i==i) cnt+=1;
				else cnt+=2;
			}
		}
		if(cnt>=maxCnt) {
			maxValue=x;
			maxCnt=cnt;
			arr[x]=x;
		}else arr[x]=maxValue;
		
	}

}
