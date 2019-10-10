//중간값 찾기
import java.util.Arrays;
import java.util.Scanner;
 
public class _2063 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[200];
         
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr,0,N);
        System.out.println(arr[N/2]);
    }
 
}