package 금요일;
import java.util.Scanner;
public class 의석이의우뚝선산2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        
        for(int tc=1; tc<=testCase; tc++){
            int n = sc.nextInt();
            int [] arr = new int[n];
            int before=0, after=0, tmp = 0, dir=0, sum=0;
            for(int i=0; i<n; i++){
                
                arr[i] = sc.nextInt();
                if(i==0){
                    before++;
                }
                else if(arr[i] > tmp && dir==0){
                    // 오르막길일때
                    before++;
                }else if(arr[i] < tmp && dir == 1){
                    // 내리막길일때
                    after++;
                    if(i==n-1){
                        sum += before*after;
                    }
                }else if(arr[i] < tmp && dir == 0){
                    // 내리막길일때
                    before--;
                    after++;
                    dir=1;
                    if(i==n-1){
                        sum += before*after;
                    }
                }else if(arr[i] > tmp && dir==1){
                    dir = 0;
                    sum += before*after;
                    before = 2;
                    after = 0;
                }
                tmp = arr[i];
            }
            System.out.println("#" + tc+ " " + sum);
        }
    }
}