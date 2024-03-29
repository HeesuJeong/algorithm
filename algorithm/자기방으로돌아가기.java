import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//망한코드~~~~~~~
public class 자기방으로돌아가기 {

	static int T;
	static int N;
	static int stuNum;
	static Scanner sc = new Scanner(System.in);

	static class room {
		int from;
		int to;

		public room(int from, int to) {
			// TODO Auto-generated constructor stub
			this.from = from;
			this.to = to;
		}
	}

	static LinkedList<room> leftList;
	static LinkedList<room> rightList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			int lcnt = 0;
			int rcnt = 0;
			leftList = new LinkedList<>();
			rightList = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int tmpfrom = sc.nextInt();
				int tmpto = sc.nextInt();
				if (tmpfrom < tmpto) {
					leftList.add(new room(tmpfrom, tmpto));
					lcnt++;
				} else {
					rightList.add(new room(tmpfrom, tmpto));
					rcnt++;
				}
			}
			Comparator com = new Comparator<room>() {

				@Override
				public int compare(room o1, room o2) {
					// TODO Auto-generated method stub
					return o2.to - o1.to;
				}
			};

			Comparator<room> com2 =new Comparator<room>() {

				@Override
				public int compare(room o1, room o2) {
					// TODO Auto-generated method stub
					return o2.from-o1.from;
				}
			}; 
			Collections.sort(leftList, com);
			Collections.sort(rightList, com2);
			int end=0;
			int start=0;
			int cnt = 1;
			
			if(lcnt!=0&&rcnt!=0&&leftList.get(0).to>rightList.get(rcnt-1).to) cnt++;
			if (lcnt != 0) {
				end = leftList.get(0).to;
				start = leftList.get(0).from;
				for (int i = 1; i < leftList.size(); i++) {
					if (start < leftList.get(i).to) {
						cnt++;
					}
					end = leftList.get(i).to;
					start = leftList.get(i).from;
				}
			}
			// cnt-=1;
			if (rcnt != 0) {
				end = rightList.get(0).to;
				start = rightList.get(0).from;
				for (int i = 1; i < rightList.size(); i++) {
					if (end < rightList.get(i).from) {
						cnt++;
					}
					end = rightList.get(i).to;
					start = rightList.get(i).from;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		} // tc
	}

}
