package 상호배타집합;
//사람과 사람의 관계 정하는 문제에 적용 가능
//disjoint-sets문제
import java.util.Arrays;

public class 상호배타집합 {
	static int[] parents;

	public static void main(String[] args) {
		parents = new int[10];
		for (int i = 0; i < parents.length; i++)
			makeSet(i);
		union(0, 1);
		printSet();
		union(2, 3);
		printSet();
		union(0, 3);
		printSet();
		union(4, 5);
		printSet();
		union(6, 7);
		printSet();
		union(4, 7);
		printSet();
		union(3, 5);
		printSet();
		union(1, 8);
		printSet();
		union(0, 9);
		printSet();

	}

	
	static void printSet() {
		//부모알기
		//System.out.println(Arrays.toString(parents));
		
		// 대표자 알기
		for (int i = 0; i < parents.length; i++) {
			System.out.print(findSet(i)+" ");
		}
		System.out.println();
	}

	static void makeSet(int x) {
		// 자기 자신을 자신의 부모로 지정
		// 즉 원소가 하나인 집합을 구성하는거다
		parents[x] = x;
	}

	static int findSet(int x) {
		// 재귀적으로 부모를 찾아 올라가 루트를 반환
		// 재귀의 기저영역은 자신의 부모가 자기자신인 경우. 리턴 나
		// 재귀호출은 자신의 부모에 대해서 다시 findSet
		if (parents[x] == x)
			return x;
		/*계속해서 재귀하고 리턴해야하는 비효율적인 코드
		return findSet(parents[x]);*/
		parents[x]=findSet(parents[x]);
		return parents[x];
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		// 아무나 부모가 되면 되는데 우린 뒤엣놈이 부모가 되기
		parents[px] = py;
	}

}
