import java.util.Arrays;
import java.util.Comparator;

public class test {
	
public static void main(String[] args) {
	String[] arr= {"min","ddu","don'tgo","hey"};
	Arrays.sort(arr,new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.charAt(1)-o2.charAt(1);
		}
	});
	System.out.println(Arrays.toString(arr));
}
}
