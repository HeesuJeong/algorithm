package 수요일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class 숫자게임_근창 {
    static int max;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int test_case = Integer.parseInt(bf.readLine());
       for(int t=1; t<=test_case; t++) {
           
           int num = Integer.parseInt(bf.readLine());
           max = 0;
           divided2(num, 0);
                       
           bw.write("#" + t + " " + max + "\n");
           bw.flush();
       }
       bw.close();
    }
    static void divided2(int num, int turn) {
        
        if(num < 10) {
            
            if(max < turn)
                max = turn;
            return;
        }
        
        int n1 = 10;
        while(true) {
            
            if(num < n1)
                break;
            
            int a = num / n1;
            int b = num % n1;
            int n2 = 10;
            while(true) {
                
                if(b < n2)
                    break;
                
                int aa = b / n2;
                int bb = b % n2;
                int n3 = 10;
                while(true) {
                    
                    if(bb < n3)
                        break;
                    
                    int aaa = bb / n3;
                    int bbb = bb % n3;
                    int n4 = 10;
                    while(true) {
                        
                        if(bbb < n4)
                            break;
                        
                        int aaaa = bbb / n4;
                        int bbbb = bbb % n4;
                        
                        divided2(a*aa*aaa*aaaa*bbbb, turn+1);
                        n4 *= 10;
                    }
                    
                    divided2(a*aa*aaa*bbb, turn+1);
                    n3 *= 10;
                }
                
                divided2(a*aa*bb, turn+1);
                n2 *= 10;
            }
            
            divided2(a*b, turn+1);
            n1 *= 10;
        }
    }
}