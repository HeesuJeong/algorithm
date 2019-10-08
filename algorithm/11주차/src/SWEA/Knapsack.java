package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Knapsack {

	static int[] arr;
	static int[] arrV;
	static int[] arrC;
	static int[] storedArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			StringTokenizer nk=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(nk.nextToken()); //물건개수
			int K=Integer.parseInt(nk.nextToken()); //가방의 부피
			arr=new int[K+1]; //최대부피
			storedArr=new int[K+1]; 
			arrV=new int[N+1]; //부피 저장
			arrC=new int[N+1]; //가치 저장
			for (int i = 1; i <= N; i++) {
				nk=new StringTokenizer(br.readLine());
				arrV[i]=Integer.parseInt(nk.nextToken());
				arrC[i]=Integer.parseInt(nk.nextToken());
			}
			
		
			for (int i = 1; i <=N; i++) {
				int v=arrV[i];
				int c=arrC[i];
				for (int j = 0; j <=K; j++) {
					if(j>=v) {
					int tmp=storedArr[j-v]+c;
					arr[j]=Math.max(tmp, storedArr[j]);
					}else arr[j]=storedArr[j];
				}
				storedArr=arr.clone();
			}
			System.out.println("#"+tc+" "+arr[K]);
		}//tc
		
	}

}
