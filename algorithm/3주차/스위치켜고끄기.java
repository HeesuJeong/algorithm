import java.util.Scanner;

public class 스위치켜고끄기 {
	static int[] sArr;
	static int switchNum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		switchNum = sc.nextInt();
		sArr = new int[switchNum + 1];
		for (int i = 1; i <= switchNum; i++) {
			sArr[i] = sc.nextInt();
		}
		int stNum = sc.nextInt();
		for (int i = 0; i < stNum; i++) {
			int gen = sc.nextInt();
			int posi = sc.nextInt();
			if (gen == 1) {
				man(posi);
			} else if (gen == 2) {
				woman(posi);
			}
		} // 성별
		
		
		for (int i = 1; i <= switchNum; i++) {
			System.out.print(sArr[i]+" ");
			if(i%20==0) System.out.println();
		}
	}// main

	public static void man(int posi) {
		
		int jmp = 1;
		int pp=posi;
		while (pp <= switchNum) {// 인자값의 배수 위치 바꾸기
			change(pp);
			pp = posi * (++jmp);
		}
	}

	public static void woman(int posi) {
		int jmp = 0;
		while (posi - jmp >= 1 && posi + jmp <= switchNum) {// posi 기준으로 좌우로 확대
			if (sArr[posi - jmp] == sArr[posi + jmp]) {
				if (jmp == 0) { // 나만 같다면 나만 바꾸기
					change(posi);
					jmp++;
				} else {// 좌우 대칭이면 바꾸기
					change(posi - jmp);
					change(posi + jmp);
					jmp++;
				}
			} else {// 다른경우
				break;
			}
		}
	}

	public static void change(int i) {
		if (sArr[i] == 0) {
			sArr[i] = 1;
		} else if (sArr[i] == 1) {
			sArr[i] = 0;
		}
	}
	
	
}
