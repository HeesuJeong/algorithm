package 금요일;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(7001);
			
			while(true) {
			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress());
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 바이트 스트림을 문자열스트림으로 변환해주기 위해 OutputStreamWriter 필요
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//쓰는 채널 쌓기
			ServerThread.bwList.add(bw);
			new Thread(new ServerThread(br)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
