package 금요일;

class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("스레드다!!!!!!!!!!!");
	}
	
}
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//스레드란 명령처리 흐름
		Thread t=new Thread(new MyRunnable());
		t.start();
	}

}
