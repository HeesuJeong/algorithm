package 수요일;

public class MaxHeap {
	private int[] tree=new int[128];
	private int cnt=1;
	
	public void add(int data) {
		tree[cnt]=data;
		int tmpidx=cnt;
		while(tmpidx>1&&tree[tmpidx]>tree[tmpidx/2]) {
			int tmp=tree[tmpidx];
			tree[tmpidx]=tree[tmpidx/2];
			tree[tmpidx/2]=tmp;
			tmpidx=tmpidx/2;
		}
		cnt++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap heap=new MaxHeap();
		heap.add(13);
		heap.add(10);
		heap.add(12);
		heap.add(18);
		heap.add(20);
		heap.add(29);
		for (int i = 1; i < heap.cnt; i++) {
			System.out.print(heap.tree[i]+" ");
		}
	}

}
