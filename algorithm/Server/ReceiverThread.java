package 금요일;

import java.io.BufferedReader;
import java.io.IOException;

public class ReceiverThread implements Runnable{

	BufferedReader br;
	String ipstr;
	public ReceiverThread(BufferedReader br) {
		this.br=br;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String msg=null;
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
