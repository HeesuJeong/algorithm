package 금요일;

public class PowerSet_Bitmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,5};
		StringBuilder test=new StringBuilder();
		test.append("hi");
		System.out.println(test.length());
		
		for (int i = 0; i < 1<<arr.length; i++) {
			StringBuilder sb=new StringBuilder();
			for (int j = 0; j < arr.length; j++) {
				if(((1<<j)&i)!=0) {
					sb.append(arr[j]).append(" ");
				}
			}
			if(sb.length()==4)
			System.out.println(sb.toString());
		}
	}

}
