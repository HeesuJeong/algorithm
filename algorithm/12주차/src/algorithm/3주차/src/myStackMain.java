import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class myStackMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		myStack<Integer> ms=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1. 파일에서 읽기\n2.새로 생성");
		int sel=sc.nextInt();
		if(sel==1) {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("stackTest.txt"));
			ms=(myStack)ois.readObject();
			ois.close();
		}else {
			ms=new myStack(5);
		}
		while(true) {
			System.out.println("1.Push\n2.Pop\n0.파일 저장 후 종료\n-1.저장 안 하고 종료");
			sel=sc.nextInt();
			if(sel==1) {
				int data=sc.nextInt();
				ms.push(data);
			}else if(sel==2) {
				ms.pop();
			}else if(sel==0) {
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("stackTest.txt"));
				oos.writeObject(ms);
				oos.close();
				break;
			}else if(sel==-1) {
				break;
			}
		}
	}

}
