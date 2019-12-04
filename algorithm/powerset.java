import java.util.Scanner;
public class powerset{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[102][102];
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int hor = sc.nextInt();
            int ver = sc.nextInt();
            System.out.println(hor + 10);
            System.out.println(ver + 10);
            for (int row = hor; row <= hor + 10; row++) {
                for (int col = ver; col <= col + 10; col++) {
                    arr[row][col] = 1;
                }
            }
        }
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}