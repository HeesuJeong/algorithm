package 금요일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerThread implements Runnable{
	BufferedReader br;//자신이 읽기를 수행할 br
	static List<BufferedWriter> bwList=new ArrayList<>();
	
	public ServerThread(BufferedReader br) {
		// TODO Auto-generated constructor stub
		this.br=br;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String msg=null;
		try {
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
				for(BufferedWriter bw:bwList) {
					bw.write(msg+"\n");
					bw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
